package br.com.codecompany.rysys.core.jce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.core.balancing.BalancingStrategyFactory;

public final class EncryptorStrategyFactory {
	private static final Logger log = LoggerFactory.getLogger(BalancingStrategyFactory.class);
	
	public static final String DES = "DES";
	public static final String PLAIN = "PLAIN";

	public static final Encrypter getStrategy(String type) {
		Encrypter strategy = null;
		
		if (type == null || "".equals(type.trim())) {
			log.warn("No encrypter strategy specified. Using " + PLAIN);
			type = PLAIN;
		}

		type = type.trim().toUpperCase();
		if (PLAIN.equals(type)) {
			strategy = new PlainEncrypter();
		}
		else if (DES.equals(type)) {
			strategy = new DESEncrypter();
		} 
		else {
			try {
				Class<?> clazz = Class.forName(type);
				strategy = (Encrypter) clazz.newInstance();
			} catch (Exception e) {
				strategy = null;
				log.error("Can't initialize '" + type + "'. Valid strategies are: " +
					  "PLAIN, DES or a full name of a class which implements " + 
					  Encrypter.class.getSimpleName());
			}
		}
		
		if (strategy == null) {
			throw new InvalidEncrypterStrategyException("'" + type
					+ "' is not a valid encryptor strategy");
		}
		
		return strategy;
	}
}
