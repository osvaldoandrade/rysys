package br.com.codecompany.rysys.core.jce;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncrypterHelper {
	
	private static final Logger log = LoggerFactory.getLogger(EncrypterHelper.class);
	
	public static final String decryptPassword(String text) {
		String result = "";
		boolean matches = false;
		if (!text.startsWith("{}")) {
			Pattern pattern = Pattern.compile("(\\{(.+)\\})?(.+)");
			Matcher matcher = pattern.matcher(text);
			matches = matcher.matches();

			String strategy = matcher.group(2);
			String password = matcher.group(3);
			
			if (strategy == null || "".equals(strategy.trim())) {
				strategy = EncryptorStrategyFactory.PLAIN;
			}
			
			Encrypter encrypter = EncryptorStrategyFactory.getStrategy(strategy);
			log.info("Decrypting using " + encrypter.getName() + " strategy");
			result = encrypter.decrypt(password);
		}
		
		if (!matches) {
			throw new InvalidPasswordFormatException("Invalid password format: " + text + 
					". Use [{algorithm}password] for encrypted passwords or " +
					"[password] for plain ones");			
		}
		return result;
	}
}
