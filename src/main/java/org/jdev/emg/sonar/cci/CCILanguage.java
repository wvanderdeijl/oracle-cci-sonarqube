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

import com.google.common.collect.Lists;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import org.sonar.api.config.Settings;
import org.sonar.api.resources.AbstractLanguage;


/**
 * cci analysis requires its own language so all files are processed.
 */
public class CCILanguage extends AbstractLanguage {

    private final Settings settings;

    public CCILanguage(Settings settings) {
        super(CCIPlugin.LANGUAGE_KEY, CCIPlugin.LANGUAGE_NAME);
        this.settings = settings;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.sonar.api.resources.AbstractLanguage#getFileSuffixes()
     */
    @Override
    public String[] getFileSuffixes() {
        String[] suffixes = filterEmptyStrings(settings.getStringArray(CCIPlugin.FILE_SUFFIXES_KEY));
        if (suffixes.length == 0) {
            suffixes = StringUtils.split(CCIPlugin.FILE_SUFFIXES_DEFVALUE, ",");
        }
        return addDot(suffixes);
    }

    /**
     * method for adding a dot in front of the suffix.
     * @param suffixes
     * @return
     */
    private static String[] addDot(String[] suffixes) {
        String[] results = new String[suffixes.length];
        for (int i = 0; i < suffixes.length; i++) {
            String suffix = suffixes[i];
            String dot = suffix.startsWith(".") ? "" : ".";
            results[i] = dot + suffix;
        }
        return results;
    }
    
    /**
     * method for filtering the empty string.
     * @param stringArray
     * @return
     */
    private static String[] filterEmptyStrings(String[] stringArray) {
        List<String> nonEmptyStrings = Lists.newArrayList();
        for (String string : stringArray) {
            if (StringUtils.isNotBlank(string.trim())) {
                nonEmptyStrings.add(string.trim());
            }
        }
        return nonEmptyStrings.toArray(new String[nonEmptyStrings.size()]);
    }
}
