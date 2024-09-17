package br.com.codecompany.rysys.util;

import org.slf4j.Logger;

public class CheckUtils {
		
	public static final void checkNull(Logger log, Object object, String property, Object value) {
		if (object != null) {
			if (value == null) {
				log.warn("Property '" + object.getClass().getSimpleName() +  
						"." + property + "' is null");
			}
		}
		else {
			log.error("Object is null");
		}
	}
	
}
