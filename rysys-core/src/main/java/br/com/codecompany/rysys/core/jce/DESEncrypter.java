package br.com.codecompany.rysys.core.jce;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DESEncrypter implements Encrypter {

	private static final Logger log = LoggerFactory.getLogger(DESEncrypter.class);

	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	public static final String DES_ENCRYPTION_SCHEME = "DES";
	public static final String DEFAULT_ENCRYPTION_KEY = "This is a fairly long phrase used to encrypt";

	private KeySpec keySpec;
	private SecretKeyFactory keyFactory;
	private Cipher cipher;

	private static final String UNICODE_FORMAT = "UTF8";

	public DESEncrypter() {
		this("DES", DEFAULT_ENCRYPTION_KEY);
	}

	public DESEncrypter(String encryptionScheme, String encryptionKey) {

		if (encryptionKey == null) {
			throw new IllegalArgumentException("encryption key was null");
		}

		if (encryptionKey.trim().length() < 24) {
			throw new IllegalArgumentException(
					"encryption key was less than 24 characters");
		}

		try {
			byte[] keyAsBytes = encryptionKey.getBytes(UNICODE_FORMAT);

			if (encryptionScheme.equals(DESEDE_ENCRYPTION_SCHEME)) {
				keySpec = new DESedeKeySpec(keyAsBytes);
			} else if (encryptionScheme.equals(DES_ENCRYPTION_SCHEME)) {
				keySpec = new DESKeySpec(keyAsBytes);
			} else {
				throw new IllegalArgumentException(
						"Encryption scheme not supported: " + encryptionScheme);
			}

			keyFactory = SecretKeyFactory.getInstance(encryptionScheme);
			cipher = Cipher.getInstance(encryptionScheme);

		} catch (Exception e) {
			log.error("Could not create encrypter", e);
		}
	}

	public String encrypt(String unencryptedString) {
		if (unencryptedString == null || unencryptedString.trim().length() == 0) {
			throw new IllegalArgumentException(
					"unencrypted string was null or empty");
		}

		try {
			SecretKey key = keyFactory.generateSecret(keySpec);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] cleartext = unencryptedString.getBytes(UNICODE_FORMAT);
			byte[] ciphertext = cipher.doFinal(cleartext);
			return new String(Base64Coder.encode(ciphertext));
		} catch (Exception e) {
			log.error("Could not encrypt text", e);
			return null;
		}
	}

	public String decrypt(String encryptedString) {
		if (encryptedString == null || encryptedString.trim().length() <= 0) {
			throw new IllegalArgumentException(
					"encrypted string was null or empty");
		}

		try {
			SecretKey key = keyFactory.generateSecret(keySpec);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] cleartext = Base64Coder.decode(encryptedString);
			byte[] ciphertext = cipher.doFinal(cleartext);

			return bytes2String(ciphertext);
		} catch (Exception e) {
			log.error("Could not decrypt text", e);
			return null;
		}
	}

	private static String bytes2String(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			stringBuffer.append((char) bytes[i]);
		}
		return stringBuffer.toString();
	}

	public String getName() {
		return DES_ENCRYPTION_SCHEME;
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: " + DESEncrypter.class.getSimpleName()
					+ "[-e|-d] <text to encrypt>");
		} else {
			DESEncrypter encrypter = new DESEncrypter();
			if (args[0].toLowerCase().equals("-e")) {
				System.out.println("Encrypted text is ["
						+ encrypter.encrypt(args[1]) + "]");
			} else if (args[0].toLowerCase().equals("-d")) {
				System.out.println("Decrypted text is ["
						+ encrypter.decrypt(args[1]) + "]");
			} else {
				System.err.println("Invalid parameter. Please enter -e or -d");
			}
		}
	}
}
