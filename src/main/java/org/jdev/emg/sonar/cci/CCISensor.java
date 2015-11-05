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


import java.io.File;

import java.util.HashMap;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.FilePredicate;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.rule.CheckFactory;
import org.sonar.api.batch.rule.Checks;
import org.sonar.api.component.ResourcePerspectives;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.resources.Project;
import org.sonar.api.utils.command.Command;
import org.sonar.api.utils.command.CommandExecutor;


public class CCISensor implements Sensor {

    private static final Logger LOG = LoggerFactory.getLogger(CCISensor.class);

    private final Checks<Object> checks;
    private final CCIConfiguration config;
    private final FileSystem fileSystem;
    private final ResourcePerspectives resourcePerspectives;
    private final RulesProfile profile;
    private final FilePredicate mainFilesPredicate;

    public CCISensor(CCIConfiguration config, FileSystem fileSystem, RulesProfile profile, ResourcePerspectives resourcePerspectives, CheckFactory checkFactory) {
        this.checks = checkFactory.create(CCIPlugin.SONAR_REPOS_KEY);
        this.config = config;
        this.fileSystem = fileSystem;
        this.profile = profile;
        this.resourcePerspectives = resourcePerspectives;
        this.mainFilesPredicate =
                fileSystem.predicates().and(fileSystem.predicates().hasType(InputFile.Type.MAIN), fileSystem.predicates().hasLanguage(CCIPlugin.LANGUAGE_KEY));
    }

    @Override
    public boolean shouldExecuteOnProject(Project project) {
        boolean retval = CCIPlugin.LANGUAGE_KEY.equals(project.getLanguageKey());
        if (!retval) {
            LOG.debug(this.getClass().getName() + " not executing on project with language " +
                      project.getLanguageKey());
        }
        return retval;
    }

    /**
     * Performs analysis on a given project and reports measures (violations) to the given context.
     * @param project Project to analyse
     * @param context SensorContext where measures (violations) should be reported to
     */
    @Override
    public void analyse(Project project, SensorContext context) {
        executeAudit();
        collectMeasures(new File(fileSystem.baseDir().getAbsolutePath() + File.separator + "target" + File.separator + "sonar" + File.separator + "._ComplianceReport.xml"), project, context, resourcePerspectives);
    }

    /**
     * Runs ojaudit and saves the output to the given file.
     */
    protected void executeAudit() {
        String cmd = null;
        try {
            long start = System.currentTimeMillis();
            Command command =
                Command.create(config.getExecutable().getCanonicalPath());
            command = command.addArgument("-inputDir").addArgument(".");
            command = command.addArgument("-outputDir").addArgument(fileSystem.baseDir().getAbsolutePath() + File.separator + "target" + File.separator + "sonar");
            cmd = command.toCommandLine();
            LOG.info("executing {}", cmd);
            CommandExecutor executor = CommandExecutor.create();
            int exitCode = executor.execute(command, 10 * 1000);
            if (exitCode != 0) {
                throw new IllegalStateException("The exit code was " + exitCode +
                                                " when 0 was expected for command: " + command);
            }
            LOG.info("cci completed in {} ms", System.currentTimeMillis() - start);
        } catch (Exception e) {
            throw new CCIException("error running cci" + (cmd == null ? "" : " (" + cmd + ")"), e);
        }
    }

    /**
     * Parses an cci output file and report all violations as measures to the given context.
     * @param output XML output of ojaudit execution that will be parsed
     * @param project Project being analyzed
     * @param context SensorContext where measures/violations should be reported to
     * @see CCIResultsParser
     */
    protected void collectMeasures(File output, Project project, SensorContext context,
                                   ResourcePerspectives resourcePerspectives) {
        long start = System.currentTimeMillis();
        CCIResultsParser parser = new CCIResultsParser(project, profile, context, resourcePerspectives);
        parser.parse(output, fileSystem.baseDir().getAbsolutePath(), getFiles());
        LOG.info("cci results analysed in {} ms", System.currentTimeMillis() - start);
    }
    
    /**
     * Collect all inputFiles that are scanned and place them in a map.
     * @return MAP of inputFiles.
     */
    private Map<String, InputFile> getFiles() {
        Map<String, InputFile> map = new HashMap<String, InputFile>();
        for(InputFile inputFile : fileSystem.inputFiles(mainFilesPredicate)) {
            LOG.debug("$$$ mapfile: {}", inputFile.absolutePath());
            map.put(inputFile.absolutePath(), inputFile);
        }
        return map;
    }
}
