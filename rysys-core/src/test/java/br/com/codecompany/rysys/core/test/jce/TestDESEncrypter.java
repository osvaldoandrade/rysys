package br.com.codecompany.rysys.core.test.jce;

import org.junit.Assert;
import org.junit.Test;

import br.com.codecompany.rysys.core.jce.DESEncrypter;

public class TestDESEncrypter {

	@Test
	public void encryptionKeyIsDefined() {
		Assert.assertEquals(DESEncrypter.DEFAULT_ENCRYPTION_KEY,
				"This is a fairly long phrase used to encrypt");
	}

	@Test
	public void encryptsUsingDesEde() throws Exception {
		String stringToEncrypt = "test";
		String encryptionKey = "123456789012345678901234567890";
		String encryptionScheme = DESEncrypter.DESEDE_ENCRYPTION_SCHEME;

		DESEncrypter encrypter = new DESEncrypter(encryptionScheme,
				encryptionKey);
		String encryptedString = encrypter.encrypt(stringToEncrypt);

		Assert.assertEquals("Ni2Bih3nCUU=", encryptedString);
	}

	@Test
	public void encryptsUsingDes() throws Exception {
		String stringToEncrypt = "test";
		String encryptionKey = "123456789012345678901234567890";
		String encryptionScheme = DESEncrypter.DES_ENCRYPTION_SCHEME;

		DESEncrypter encrypter = new DESEncrypter(encryptionScheme,
				encryptionKey);
		String encryptedString = encrypter.encrypt(stringToEncrypt);

		Assert.assertEquals("oEtoaxGK9ns=", encryptedString);
	}

	@Test
	public void encryptionKeyCanContainLetters() throws Exception {
		String string = "test";
		String encryptionKey = "ASDF asdf 1234 8983 jklasdf J2Jaf8";
		String encryptionScheme = DESEncrypter.DESEDE_ENCRYPTION_SCHEME;

		DESEncrypter encrypter = new DESEncrypter(encryptionScheme,
				encryptionKey);
		String encryptedString = encrypter.encrypt(string);

		Assert.assertEquals("Q+UyPrxdge0=", encryptedString);
	}

	@Test
	public void decryptsUsingDesEde() throws Exception {
		String string = "Ni2Bih3nCUU=";
		String encryptionKey = "123456789012345678901234567890";
		String encryptionScheme = DESEncrypter.DESEDE_ENCRYPTION_SCHEME;

		DESEncrypter encrypter = new DESEncrypter(encryptionScheme,
				encryptionKey);
		String decryptedString = encrypter.decrypt(string);

		Assert.assertEquals("test", decryptedString);
	}

	@Test
	public void decryptsUsingDes() throws Exception {
		String string = "oEtoaxGK9ns=";
		String encryptionKey = "123456789012345678901234567890";
		String encryptionScheme = DESEncrypter.DES_ENCRYPTION_SCHEME;

		DESEncrypter encrypter = new DESEncrypter(encryptionScheme,
				encryptionKey);
		String decryptedString = encrypter.decrypt(string);

		Assert.assertEquals("test", decryptedString);
	}

	@Test
	public void cantInstantiateWithNullEncryptionKey() throws Exception {
		try {
			String encryptionScheme = DESEncrypter.DESEDE_ENCRYPTION_SCHEME;
			String encryptionKey = null;

			new DESEncrypter(encryptionScheme, encryptionKey);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("encryption key was null", e.getMessage());
		}

	}

	@Test
	public void cantInstantiateWithEmptyEncryptionKey() throws Exception {
		try {
			String encryptionScheme = DESEncrypter.DESEDE_ENCRYPTION_SCHEME;
			String encryptionKey = "";

			new DESEncrypter(encryptionScheme, encryptionKey);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("encryption key was less than 24 characters", e
					.getMessage());
		}

	}

	@Test
	public void cantDecryptWithNullString() throws Exception {
		try {
			String encryptionScheme = DESEncrypter.DESEDE_ENCRYPTION_SCHEME;
			String encryptionKey = "123456789012345678901234";

			DESEncrypter encrypter = new DESEncrypter(encryptionScheme,
					encryptionKey);
			encrypter.decrypt(null);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("encrypted string was null or empty", e.getMessage());
		}

	}

	@Test
	public void cantDecryptWithEmptyString() throws Exception {
		try {
			String encryptionScheme = DESEncrypter.DESEDE_ENCRYPTION_SCHEME;
			String encryptionKey = "123456789012345678901234";

			DESEncrypter encrypter = new DESEncrypter(encryptionScheme,
					encryptionKey);
			encrypter.decrypt("");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("encrypted string was null or empty", e.getMessage());
		}

	}

	@Test
	public void cantEncryptWithNullString() throws Exception {
		try {
			String encryptionScheme = DESEncrypter.DESEDE_ENCRYPTION_SCHEME;
			String encryptionKey = "123456789012345678901234";

			DESEncrypter encrypter = new DESEncrypter(encryptionScheme,
					encryptionKey);
			encrypter.encrypt(null);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("unencrypted string was null or empty", e.getMessage());
		}

	}

	@Test
	public void cantEncryptWithEmptyString() throws Exception {
		try {
			String encryptionScheme = DESEncrypter.DESEDE_ENCRYPTION_SCHEME;
			String encryptionKey = "123456789012345678901234";

			DESEncrypter encrypter = new DESEncrypter(encryptionScheme,
					encryptionKey);
			encrypter.encrypt("");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("unencrypted string was null or empty", e.getMessage());
		}
	}
}