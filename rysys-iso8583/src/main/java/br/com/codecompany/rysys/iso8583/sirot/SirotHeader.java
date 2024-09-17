package br.com.codecompany.rysys.iso8583.sirot;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.iso8583.driver.Header;
import br.com.codecompany.rysys.iso8583.driver.InvalidHeaderException;

public class SirotHeader implements Header {

	public static final int HEADER_SIZE = 64;
	
	private static Logger log = LoggerFactory.getLogger(SirotHeader.class);
	
	private int messageSize;
	private byte[] headerAsByteArray;
	private String headerAsString;
	
	public SirotHeader(byte[] header) {
		if (header == null || header.length != HEADER_SIZE) {
			throw new InvalidHeaderException("Header must have " + HEADER_SIZE + " bytes");
		}
		this.messageSize = ((header[11] & 0xff) << 8) | (header[12] & 0xff);
		this.headerAsByteArray = header;
		this.headerAsString = new String(header);
	}
			
	public SirotHeader(int messageSize, int transmissionChannel) {
		this.messageSize = messageSize;
		createHeader(transmissionChannel);
	}
	
	private void createHeader(int transmissionChannel) {
		// allocate byte array
		headerAsByteArray = new byte[HEADER_SIZE];

		// signature (9 bytes)
		byte[] bytesSignature = "SIROT/002".getBytes();
		for (int i = 0, j = 0; i < 9; i++, j++) {
			headerAsByteArray[i] = bytesSignature[j];
		}

		// version (2 bytes)
		int versionNumber = 1;
		headerAsByteArray[9] = (byte) ((versionNumber & 0xFF00) >> 8);
		headerAsByteArray[10] = (byte) ((versionNumber & 0x00FF));

		// message size (2 bytes)
		headerAsByteArray[11] = (byte) ((messageSize & 0xFF00) >> 8);
		headerAsByteArray[12] = (byte) ((messageSize & 0x00FF));

		// transmission channel (4 bytes)
		int channel = 0xFFFFFFFF & transmissionChannel;
		headerAsByteArray[13] = (byte) ((channel & 0xFF000000) >> 24);
		headerAsByteArray[14] = (byte) ((channel & 0x00FF0000) >> 16);
		headerAsByteArray[15] = (byte) ((channel & 0x0000FF00) >> 8);
		headerAsByteArray[16] = (byte) ((channel & 0x000000FF));

		// UID (8 bytes)
		String uid = String.valueOf(System.nanoTime());
		if (uid.length() >= 8) {
			uid = StringUtils.right(uid, 8);
		} else {
			uid = StringUtils.leftPad(uid, 8, "0");
		}
		byte[] bytesUid = uid.getBytes();
		for (int i = 17, j = 0; i < 25; i++, j++) {
			headerAsByteArray[i] = bytesUid[j];
		}

		// reset bit map
		for (int i = 25; i < 64; i++) {
			headerAsByteArray[i] = (byte) 0x00;
		}

		// elapsed time (4 bytes)
		int elapsedTime = 0;
		headerAsByteArray[29] = (byte) ((elapsedTime & 0xFF000000) >> 24);
		headerAsByteArray[30] = (byte) ((elapsedTime & 0x00FF0000) >> 16);
		headerAsByteArray[31] = (byte) ((elapsedTime & 0x0000FF00) >> 8);
		headerAsByteArray[32] = (byte) ((elapsedTime & 0x000000FF));

		// application name (6 bytes)
		String app = "RYSYS ";
		byte[] bytesApp = app.getBytes();
		for (int i = 38, j = 0; i < 44; i++, j++) {
			headerAsByteArray[i] = bytesApp[j];
		}

		// task id (20 bytes)
		String taskId = "localhost";
		try {
			InetAddress addr = InetAddress.getLocalHost();
			taskId = addr.getHostName();
		} catch (UnknownHostException e) {
			log.error("Could not retrieve host name", e);
		}
		if (taskId.length() >= 20) {
			taskId = StringUtils.left(taskId, 20);
		} else {
			taskId = StringUtils.rightPad(taskId, 20, " ");
		}
		byte[] bytesTaskId = taskId.getBytes();
		for (int i = 44, j = 0; i < 64; i++, j++) {
			headerAsByteArray[i] = bytesTaskId[j];
		}

		headerAsString = new String(headerAsByteArray);
	}
	
	public int getBodySize() {
		return messageSize;
	}
	
	public byte[] asByteArray() {
		return headerAsByteArray;
	}
	
	public String asString() {
		return headerAsString;
	}
	
	public int getHeaderSize() {
		return HEADER_SIZE;
	}
}
