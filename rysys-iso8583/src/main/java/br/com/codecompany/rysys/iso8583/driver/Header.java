package br.com.codecompany.rysys.iso8583.driver;

public interface Header {
	public byte[] asByteArray();
	public String asString();
	public int getHeaderSize();
}
