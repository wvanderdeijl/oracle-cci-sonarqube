/*
 * Sonar CCI Plugin
 * Copyright (C) 2015 Whitehorses
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.jdev.emg.sonar.cci;


import com.oracle.soa.fp.governance.auditor.ObjectFactory;
import com.oracle.soa.fp.governance.auditor.ValidatorResult;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.component.ResourcePerspectives;
import org.sonar.api.issue.Issuable;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.resources.Project;
import org.sonar.api.rule.RuleKey;

/**
 * result parser based on the ResultParser of the ojaudit plugin.
 */
public class CCIResultsParser {

    private static final Logger LOG = LoggerFactory.getLogger(CCIResultsParser.class);

    private final Project project;
    private String basedir = null;
    private Map<String, InputFile> map = null;
    private final RulesProfile profile;
    private final SensorContext context;
    private final ResourcePerspectives resourcePerspectives;

    /**
     * Constructor.
     * @param project Project being analyzed by sonar
     * @param resourcePerspectives
     * @param context SensorContext where vioilations should be reported to
     */
    public CCIResultsParser(Project project, RulesProfile profile, SensorContext context, ResourcePerspectives resourcePerspectives) {
        this.project = project;
        this.profile = profile;
        this.resourcePerspectives = resourcePerspectives;
        this.context = context;
    }

    /**
     * Parse an cci output file and report any violations to the SensorContext supplied to
     * the constructor.
     * @param output cci output file
     */
    public void parse(File output, String basedir, Map<String, InputFile> map) {
        LOG.info("parsing cci's result XML file {}...", output.getAbsolutePath());
        ValidatorResult validatorResult = unmarshall(output);
        this.basedir = basedir;
        this.map = map;
        processPolicyResults(validatorResult.getPolicyResult());
    }

    /**
     * Parse an cci output file to java objects.
     * @param file ojaudit result file
     * @return Audit object as that should be the document root of an cci result file
     */
    private ValidatorResult unmarshall(File file) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            Object obj = unmarshaller.unmarshal(file);
            if (!(obj instanceof ValidatorResult)) {
                throw new CCIException("Could not parse XML file " + file.getCanonicalPath(), null);
            }
            return (ValidatorResult)obj;
        } catch (Exception e) {
            LOG.error(e.toString());
            throw new CCIException("error parsing cci output at " + file, e);
        }
    }

    private void processPolicyResults(List<ValidatorResult.PolicyResult> policyResultList) {
        for(ValidatorResult.PolicyResult policyResult : policyResultList) {
            processAssertionResults(policyResult.getAssertionResult());
        }
    }
    
    /**
     * loop through the assertion results and proces only the composites.
     * @param assertionList
     */
    private void processAssertionResults(List<ValidatorResult.PolicyResult.AssertionResult> assertionList) {
        for(ValidatorResult.PolicyResult.AssertionResult assertionResult : assertionList) {
            
            // check if the result has Fail. that means that one of the composites where failed.
            if("Fail".equalsIgnoreCase(assertionResult.getResult())) {
                Object compOrStack = assertionResult.getExecutionDetails().getCompositeOrStack();
                if(compOrStack instanceof ArrayList ) {
                    processComposite(assertionResult.getName(), (ArrayList)compOrStack);
                }
            }
        }
    }

    /**
     * Process the composite and loop through the executions.
     * @param testname
     * @param compOrStack
     */
    private void processComposite(String testname, ArrayList compOrStack) {
        for(ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite composite : (ArrayList<ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite>) compOrStack) {
            processExecution(composite.getExecution(), CCIPlugin.RULE_PREFIX + testname, basedir + File.separator, composite.getName());
        }
    }

    /**
     * Loop through the executions and process 
     * @param executionList
     * @param ruleKey
     * @param basedir
     */
    private void processExecution( List<ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution> executionList, String ruleKey, String basedir, String compositeName) {
        for( ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution execution : executionList) {
            if(execution.getStatus() == 0) {
                
                String fileLocation = execution.getArtifactLocation().getValue().replace("${inputDir}", basedir).replace('\\', '/');
                LOG.debug("$$$ fileLocation: {}", fileLocation);
                InputFile inputFile = map.get(fileLocation);
                if(inputFile != null) {
                    LOG.debug("inputFile: {}", inputFile.absolutePath());
                              
                    Issuable issuable = resourcePerspectives.as(Issuable.class, inputFile);
                    
                    Integer line = execution.getArtifactLocation().getLine() != null ? execution.getArtifactLocation().getLine().intValue() : null;
                    LOG.debug("$$$ line: {}", line);
                    
                    if(issuable != null) {
                        issuable.addIssue(issuable.newIssueBuilder()
                                          .ruleKey(RuleKey.of(CCIPlugin.SONAR_REPOS_KEY,ruleKey))
                                          .line(line)
                                          .message(execution.getActualMessage())
                                          .build());    
                    }
                }
            }   
        }    
    }
}
