/**
 * Copyright © 2011-2018 Nathan T. Freeman, Serdar Basegmez, Jesse Gallagher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openntf.xsp.sdk.platform;

import org.openntf.xsp.sdk.preferences.XspPreferences;

public class DominoHttpPlatform extends AbstractNotesDominoPlatform {

	@Override
	public String getName() {
		return "Domino HTTP Platform";
	}

	@Override
	public boolean isEnabled() {
		String status = XspPreferences.getPreferenceString(XspPreferences.DOMINO_STATUS);
		
		return !XspPreferences.STATUS_DISABLED.equals(status);
	}

	@Override
	public boolean isLocal() {
		String status = XspPreferences.getPreferenceString(XspPreferences.DOMINO_STATUS);
		
		return XspPreferences.STATUS_LOCAL.equals(status);
	}
	
	@Override
	public String getNotesIniFilePath() {
		return XspPreferences.getPreferenceString(XspPreferences.DOMINO_INIFILE_PATH);
	}

	@Override
	public String getRemoteInstallFolder() {
		return XspPreferences.getPreferenceString(XspPreferences.DOMINO_INSTALL_FOLDER);
	}

	@Override
	public String getRemoteDataFolder() {
		return XspPreferences.getPreferenceString(XspPreferences.DOMINO_DATA_FOLDER);
	}

	@Override
	public String getLocalRcpTargetFolder() {
		return getLocalInstallFolder() + "/osgi/rcp/eclipse";
	}

	@Override
	public String getRemoteRcpTargetFolder() {
		return getRemoteInstallFolder() + "/osgi/rcp/eclipse";
	}

	@Override
	public String getLocalRcpSharedFolder() {
		return getLocalInstallFolder() + "/osgi/shared/eclipse";
	}

	@Override
	public String getRemoteRcpSharedFolder() {
		return getRemoteInstallFolder() + "/osgi/shared/eclipse";
	}

	@Override
	public String getLocalWorkspaceFolder() {
		return getLocalWorkspaceFolder(null);
	}

	@Override
	public String getLocalWorkspaceFolder(String profileName) {
		// Ignore profile name!
		return getLocalDataFolder() + "/domino/workspace";
	}

	@Override
	public String getRemoteWorkspaceFolder() {
		return getRemoteWorkspaceFolder(null);
	}

	@Override
	public String getRemoteWorkspaceFolder(String profileName) {
		// Ignore profile name!
		return getRemoteDataFolder() + "/domino/workspace";
	}

	@Override
	public String getSystemFragmentFileName() {
		return "com.ibm.domino.osgi.sharedlib_1.0.0.jar";
	}

}
