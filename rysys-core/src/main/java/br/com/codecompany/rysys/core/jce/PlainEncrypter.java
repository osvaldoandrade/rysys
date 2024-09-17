package br.com.codecompany.rysys.core.jce;

public class PlainEncrypter implements Encrypter {

	public String decrypt(String value) {
		return value;
	}

	public String encrypt(String value) {
		return value;
	}

	public String getName() {
		return "PLAIN";
	}
}
