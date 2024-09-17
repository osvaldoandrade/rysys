package br.com.codecompany.rysys.iso8583.test.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.com.codecompany.rysys.iso8583.annotation.Iso8583Bit;
import br.com.codecompany.rysys.iso8583.annotation.Iso8583BitMap;

@Iso8583BitMap
public class BitMap {

	@Iso8583Bit(value=0, description="MESSAGE CODE")
	public static final String TRANSACTION_CODE = "0205";
	
	@Iso8583Bit(value=33, description="TRANSMISSION CHANNEL")
	public static final String TRANSMISSION_CHANNEL = "9683";
	
	@Iso8583Bit(value=100, description="RECEPTION CHANNEL")	
	public static final String RECEPTION_CHANNEL = "0104";
	
	@Iso8583Bit(value=3, description="PROCESSING CODE")
	private String processingCode;

	@Iso8583Bit(value=41, description="TIMESTAMP")
	private String timestamp;

	@Iso8583Bit(value=63)
	private String data;

	public String getProcessingCode() {
		return processingCode;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public String getData() {
		return data;
	}

	public BitMap(String processingCode, String data) {
		this.processingCode = processingCode;
		this.data = data;
		this.timestamp = new SimpleDateFormat("mmss", 
				Locale.getDefault()).format(new Date());
	}
}
