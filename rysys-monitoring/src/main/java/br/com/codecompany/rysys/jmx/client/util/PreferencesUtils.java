package br.com.codecompany.rysys.jmx.client.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.prefs.Preferences;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PreferencesUtils {

	private static final String PREFS_FILE = "monitoring.prefs";
	
	private static final Logger log = LoggerFactory.getLogger(PreferencesUtils.class);
	
	private Preferences prefs = Preferences.userNodeForPackage(PreferencesUtils.class);

	private static PreferencesUtils INSTANCE = new PreferencesUtils();

	private PreferencesUtils() {
		try {
			FileInputStream fis = new FileInputStream(PREFS_FILE);
			Preferences.importPreferences(fis);
		} 
		catch (FileNotFoundException e) {
			log.warn("File '" + PREFS_FILE + "' not found");
		}
		catch (Exception e) {
			log.error("Error retrieving preferences", e);
		}
	}

	public static PreferencesUtils getInstance() {
		return INSTANCE;
	}

	public String getUser() {
		return prefs.get("user", "");
	}

	public String getHost() {
		return prefs.get("host", "localhost");
	}

	public int getPort() {
		return prefs.getInt("port", 8686);
	}

	public void save(String user, String host, int port) {
		prefs.put("user", user);
		prefs.put("host", host);
		prefs.putInt("port", port);
		try {
			FileOutputStream fos = new FileOutputStream(PREFS_FILE);
			prefs.exportSubtree(fos);
		} catch (Exception e) {
			log.error("Error saving preferences", e);
		}
	}
}
