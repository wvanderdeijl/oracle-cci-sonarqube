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


import com.google.common.base.Charsets;

import java.io.File;
import java.io.IOException;

import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sonar.api.rules.XMLRuleParser;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionXmlLoader;
import org.sonar.squidbridge.rules.SqaleXmlLoader;

/**
 * RulesDefinition for creating the rules inside Sonar.
 * @author rcats
 */
public class CCIRulesDefinition implements RulesDefinition {

    private static final Logger LOG = LoggerFactory.getLogger(CCIRulesDefinition.class);

    public CCIRulesDefinition() {
        super();
    }

    /**
     * location of the rules definition file.
     * @return
     */
    protected String rulesDefinitionFilePath() {
        return "/org/sonar/plugins/cci/rules.xml";
    }

    /**
     * method for creating a repository with the rules and sqale rating.
     * @param context
     * @param repositoryKey
     * @param repositoryName
     * @param languageKey
     */
    private void defineRulesForLanguage(Context context, String repositoryKey, String repositoryName,
                                        String languageKey) {
        NewRepository repository = context.createRepository(repositoryKey, languageKey).setName(repositoryName);

        RulesDefinitionXmlLoader rulesLoader = new RulesDefinitionXmlLoader();
        rulesLoader.load(repository, this.getClass().getResourceAsStream(rulesDefinitionFilePath()),
                         Charsets.UTF_8.name());
        SqaleXmlLoader.load(repository, "/com/sonar/sqale/cci-model.xml");
        repository.done();
    }

    public List<org.sonar.api.rules.Rule> getRules() {
        return new XMLRuleParser().parse(getClass().getResourceAsStream(rulesDefinitionFilePath()));
    }

    @Override
    public void define(Context context) {
        defineRulesForLanguage(context, CCIPlugin.SONAR_REPOS_KEY,
                               CCIPlugin.SONAR_REPOS_NAME,
                               CCIPlugin.LANGUAGE_KEY);
    }


    /**********************************************************************
     * 
     * The methods down here are used to create rules, profile and sqale.
     * based on AssertionCatalogs of the CCI tool.
     * 
     **********************************************************************/

    /**
     * used for transform AssertionCatalog-AIA_11.x.xml to rules.xml
     * @return
     * @throws IOException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    private File ruleConverter() throws IOException, TransformerConfigurationException, TransformerException {
        File temp = File.createTempFile("rules", ".xml");
        transformRules(temp.getAbsolutePath() + "rules.xml");
        transformProfile(temp.getAbsolutePath() + "profile.xml");
        transformSqale(temp.getAbsolutePath() + "sqale.xml");
        return temp;
    }

    /**
     * used for transform AssertionCatalog-AIA_11.x.xml to rules.xml
     * @param outputXML
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    private void transformRules(String outputXML) throws TransformerConfigurationException, TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream =
            new StreamSource(getClass().getResourceAsStream("/org/sonar/plugins/cci/assertionCatalogToRules.xsl"));
        Transformer transformer = factory.newTransformer(xslStream);
        StreamSource in =
            new StreamSource(getClass().getResourceAsStream("/org/sonar/plugins/cci/AssertionCatalog-AIA_11.x.xml"));
        StreamResult out = new StreamResult(outputXML);
        transformer.transform(in, out);
        LOG.info("XML file is: " + outputXML);
    }

    /**
     * used for transform AssertionCatalog-AIA_11.x.xml to rules.xml
     * @param outputXML
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    private void transformProfile(String outputXML) throws TransformerConfigurationException, TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream =
            new StreamSource(getClass().getResourceAsStream("/org/sonar/plugins/cci/assertionCatalogToProfile.xsl"));
        Transformer transformer = factory.newTransformer(xslStream);
        StreamSource in =
            new StreamSource(getClass().getResourceAsStream("/org/sonar/plugins/cci/AssertionCatalog-AIA_11.x.xml"));
        StreamResult out = new StreamResult(outputXML);
        transformer.transform(in, out);
        LOG.info("XML file is: " + outputXML);
    }

    /**
     * used for transform AssertionCatalog-AIA_11.x.xml to sqale.xml
     * @param outputXML
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    private void transformSqale(String outputXML) throws TransformerConfigurationException, TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream =
            new StreamSource(getClass().getResourceAsStream("/org/sonar/plugins/cci/assertionCatalogToRuleSqale.xsl"));
        Transformer transformer = factory.newTransformer(xslStream);
        StreamSource in =
            new StreamSource(getClass().getResourceAsStream("/org/sonar/plugins/cci/AssertionCatalog-AIA_11.x.xml"));
        StreamResult out = new StreamResult(outputXML);
        transformer.transform(in, out);
        LOG.info("XML file is: " + outputXML);
    }
}
