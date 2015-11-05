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


import com.google.common.collect.ImmutableList;

import java.util.List;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;
import org.sonar.api.profiles.RulesProfile;

// http://docs.sonarsource.org/latest/apidocs/index.html
@Properties( { @Property(key = CCIPlugin.CCI_EXEC_KEY, 
                         defaultValue = "", 
                         name = "CCI executable",
                         description = "CCI executable with the full path to the script. Typically checkCompliance.bat (Windows) and checkCompliance.sh (Linux)",
                         project = true, 
                         module = true,
                         global = true),
               @Property(key = CCIPlugin.FILE_SUFFIXES_KEY, 
                         defaultValue = CCIPlugin.FILE_SUFFIXES_DEFVALUE,
                         name = "File suffixes", 
                         description = "Comma-separated list of suffixes of files to analyze.",
                         project = true, 
                         module = true,
                         global = true) })
public class CCIPlugin extends SonarPlugin {

    public static final String LANGUAGE_KEY = "cci";
    public static final String LANGUAGE_NAME = "CCI";

    public static final String SONAR_PROFILE_KEY = RulesProfile.SONAR_WAY_NAME;
    public static final String SONAR_REPOS_KEY = "cci";
    public static final String SONAR_REPOS_NAME = "cci";

    public static final String FILE_SUFFIXES_DEFVALUE = ".xml,.xsd,.jca,.wsdl,.bpmn,.mplan,.componentType,.task,.edl,.xsl";

    public static final String FILE_SUFFIXES_KEY = "sonar.cci.file.suffixes";
    public static final String CCI_EXEC_KEY = "sonar.cci.executable";
    public static final String RULE_PREFIX = "com.oracle.cci.";

    /**
     * Returns list of extension classes for this plugin.
     * @return list of extension classes
     */
    @Override
      public List getExtensions() {
        ImmutableList.Builder<Object> builder = ImmutableList.builder();
            builder.add(
        CCILanguage.class,
        CCISourceImporter.class,
        CCIConfiguration.class,
        CCISensor.class,
        CCIProfile.class,
        CCIRulesDefinition.class,
        CCIXmlMetricsDecorator.class,
        CCIJavaMetricsDecorator.class,
        CCICodeColorizerFormat.class);
            
        return builder.build();
    }
}
