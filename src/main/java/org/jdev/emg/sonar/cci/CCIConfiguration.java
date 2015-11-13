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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sonar.api.BatchExtension;
import org.sonar.api.ServerExtension;
import org.sonar.api.config.Settings;
import org.sonar.api.platform.ServerFileSystem;
import org.sonar.api.resources.Project;

/**
 * Class for holding the configurations.
 * @author rcats
 */
public class CCIConfiguration implements ServerExtension, BatchExtension {

    private static final Logger LOG = LoggerFactory.getLogger(CCIConfiguration.class);

    private final Settings settings;
    private final Project project;
    private final ServerFileSystem serverFileSystem;

    /**
     * Constructor when running the sonar server.
     * @param settings Global plugin settings at server
     * @param serverFileSystem ServerFileSystem
     */
    public CCIConfiguration(Settings settings, ServerFileSystem serverFileSystem) {
        this(settings, serverFileSystem, null);
    }

    /**
     * Constructor when running analysis through sonar-runner, ant, or maven.
     * @param settings Project settings
     * @param project Project being processed
     */
    public CCIConfiguration(Settings settings, Project project) {
        this(settings, null, project);
    }

    /**
     * Private constructor used by the two public constructors.
     * @param settings Global or project-specific plugin settings
     * @param serverFileSystem ServerFileSystem (when running at server)
     * @param project Project being processed (when running analysis)
     */
    private CCIConfiguration(Settings settings, ServerFileSystem serverFileSystem, Project project) {
        this.settings = settings;
        this.project = project;
        this.serverFileSystem = serverFileSystem;
    }

    /**
     * Gets the cci executable.
     * @return File object pointing to the cci executable
     * @see CCIPlugin#CCI_EXEC_KEY
     */
    public File getExecutable() {
        String exec = settings.getString(CCIPlugin.CCI_EXEC_KEY);
        File file = new File(exec);
        checkCanRead(file, "cci executable");
        return file;
    }
    
    /**
     * Gets the timeout (in seconds) to wait for ojaudit execution to complete, which may be the default value
     * if not explicitly set.
     * @return timeout in seconds
     * @see CCIPlugin#CCI_TIMEOUT_SECS_KEY
     */
    public int getTimeoutSecs() {
        checkKeyExists(CCIPlugin.CCI_TIMEOUT_SECS_KEY);
        return settings.getInt(CCIPlugin.CCI_TIMEOUT_SECS_KEY);
    }
    
    private void checkKeyExists(String key) {
        if (!settings.hasKey(key) && !settings.hasDefaultValue(key)) {
            throw new IllegalArgumentException(key + " not set in sonar-project.properties");
        }
    }

    /**
     * Check can read.
     * @param file
     * @param fileType
     * @return TRUE if the file is readable.
     */
    private boolean checkCanRead(File file, String fileType) {
        if (!file.canRead()) {
            LOG.warn("unable to read " + fileType + " " + file);
            return false;
        }
        return true;
    }
}
