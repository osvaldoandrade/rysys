package br.com.codecompany.rysys.core.jce;

public interface Encrypter {
	public String getName();
	public String encrypt(String value);
	public String decrypt(String value);
}
