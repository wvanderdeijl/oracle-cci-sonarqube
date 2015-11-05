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

import java.util.List;

import org.sonar.api.web.CodeColorizerFormat;
import org.sonar.colorizer.Tokenizer;
import org.sonar.xml.XmlColorizer;

/**
 * This class is based on the sonar-xml-plugin for colorizing the xml, xsd, wsdl, xslt code.
 * @author rcats
 * @see org.sonar.plugins.xml.language.XmlCodeColorizerFormat
 */
public class CCICodeColorizerFormat extends CodeColorizerFormat {
    
    public CCICodeColorizerFormat() {
        super(CCIPlugin.LANGUAGE_KEY);
    }

    public List<Tokenizer> getTokenizers() {
       return XmlColorizer.createTokenizers();
    }
}
