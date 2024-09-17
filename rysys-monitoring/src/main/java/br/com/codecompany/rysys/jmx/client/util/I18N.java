package br.com.codecompany.rysys.jmx.client.util;

import java.util.ResourceBundle;

public class I18N {
	
	private static I18N INSTANCE = new I18N();
	private ResourceBundle bundle;

	public static I18N getInstance() {
		return INSTANCE ;		 
	}
	
	private I18N() {
		bundle = ResourceBundle.getBundle("MessagesBundle");
	}
	
	public String getValue(String key) {
		String value = "*** NOT_FOUND: " + key;
		if (bundle.containsKey(key)) {
			value = bundle.getString(key);			
		}
		return value;
	}
}
