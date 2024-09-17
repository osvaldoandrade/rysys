package br.com.codecompany.rysys.iso8583.driver;

import java.util.HashMap;


import com.solab.iso8583.IsoType;
import com.solab.iso8583.parse.FieldParseInfo;

public class Iso1987AFieldsMap implements FieldsMap {
	
	HashMap<Integer, FieldParseInfo> parseMap = new HashMap<Integer, FieldParseInfo>();
	
	public Iso1987AFieldsMap() {
		// MESSAGE TYPE INDICATOR
//		parseMap.put(0, new FieldParseInfo(IsoType.NUMERIC, 4));

		// BIT MAP
		//parseMap.put(1, new FieldParseInfo(IsoType.org.jpos.iso.IFA_BITMAP, 16));

		// PAN - PRIMARY ACCOUNT NUMBER
		parseMap.put(2, new FieldParseInfo(IsoType.LLVAR, 19));

		// PROCESSING CODE
		parseMap.put(3, new FieldParseInfo(IsoType.NUMERIC, 6));

		// AMOUNT, TRANSACTION
		parseMap.put(4, new FieldParseInfo(IsoType.NUMERIC, 12));

		// AMOUNT, SETTLEMENT
		parseMap.put(5, new FieldParseInfo(IsoType.NUMERIC, 12));

		// AMOUNT, CARDHOLDER BILLING
		parseMap.put(6, new FieldParseInfo(IsoType.NUMERIC, 12));

		// TRANSMISSION DATE AND TIME
		parseMap.put(7, new FieldParseInfo(IsoType.NUMERIC, 10));

		// AMOUNT, CARDHOLDER BILLING FEE
		parseMap.put(8, new FieldParseInfo(IsoType.NUMERIC, 8));

		// CONVERSION RATE, SETTLEMENT
		parseMap.put(9, new FieldParseInfo(IsoType.NUMERIC, 8));

		// CONVERSION RATE, CARDHOLDER BILLING
		parseMap.put(10, new FieldParseInfo(IsoType.NUMERIC, 8));

		// SYSTEM TRACE AUDIT NUMBER
		parseMap.put(11, new FieldParseInfo(IsoType.NUMERIC, 6));

		// TIME, LOCAL TRANSACTION
		parseMap.put(12, new FieldParseInfo(IsoType.NUMERIC, 6));

		// DATE, LOCAL TRANSACTION
		parseMap.put(13, new FieldParseInfo(IsoType.NUMERIC, 4));

		// DATE, EXPIRATION
		parseMap.put(14, new FieldParseInfo(IsoType.NUMERIC, 4));

		// DATE, SETTLEMENT
		parseMap.put(15, new FieldParseInfo(IsoType.NUMERIC, 4));

		// DATE, CONVERSION
		parseMap.put(16, new FieldParseInfo(IsoType.NUMERIC, 4));

		// DATE, CAPTURE
		parseMap.put(17, new FieldParseInfo(IsoType.NUMERIC, 4));

		// MERCHANTS TYPE
		parseMap.put(18, new FieldParseInfo(IsoType.NUMERIC, 4));

		// ACQUIRING INSTITUTION COUNTRY CODE
		parseMap.put(19, new FieldParseInfo(IsoType.NUMERIC, 3));

		// PAN EXTENDED COUNTRY CODE
		parseMap.put(20, new FieldParseInfo(IsoType.NUMERIC, 3));

		// FORWARDING INSTITUTION COUNTRY CODE
		parseMap.put(21, new FieldParseInfo(IsoType.NUMERIC, 3));

		// POINT OF SERVICE ENTRY MODE
		parseMap.put(22, new FieldParseInfo(IsoType.NUMERIC, 3));

		// CARD SEQUENCE NUMBER
		parseMap.put(23, new FieldParseInfo(IsoType.NUMERIC, 3));

		// NETWORK INTERNATIONAL IDENTIFIEER
		parseMap.put(24, new FieldParseInfo(IsoType.NUMERIC, 3));

		// POINT OF SERVICE CONDITION CODE
		parseMap.put(25, new FieldParseInfo(IsoType.NUMERIC, 2));

		// POINT OF SERVICE PIN CAPTURE CODE
		parseMap.put(26, new FieldParseInfo(IsoType.NUMERIC, 2));

		// AUTHORIZATION IDENTIFICATION RESP LEN
		parseMap.put(27, new FieldParseInfo(IsoType.NUMERIC, 1));

		// AMOUNT, TRANSACTION FEE
		parseMap.put(28, new FieldParseInfo(IsoType.AMOUNT, 9));

		// AMOUNT, SETTLEMENT FEE
		parseMap.put(29, new FieldParseInfo(IsoType.AMOUNT, 9));

		// AMOUNT, TRANSACTION PROCESSING FEE
		parseMap.put(30, new FieldParseInfo(IsoType.AMOUNT, 9));

		// AMOUNT, SETTLEMENT PROCESSING FEE
		parseMap.put(31, new FieldParseInfo(IsoType.AMOUNT, 9));

		// ACQUIRING INSTITUTION IDENT CODE
		parseMap.put(32, new FieldParseInfo(IsoType.LLVAR, 11));

		// FORWARDING INSTITUTION IDENT CODE
		parseMap.put(33, new FieldParseInfo(IsoType.LLVAR, 11));

		// PAN EXTENDED
		parseMap.put(34, new FieldParseInfo(IsoType.LLVAR, 28));

		// TRACK 2 DATA
		parseMap.put(35, new FieldParseInfo(IsoType.LLVAR, 37));

		// TRACK 3 DATA
		parseMap.put(36, new FieldParseInfo(IsoType.LLLVAR, 104));

		// RETRIEVAL REFERENCE NUMBER
		parseMap.put(37, new FieldParseInfo(IsoType.ALPHA, 12));

		// AUTHORIZATION IDENTIFICATION RESPONSE
		parseMap.put(38, new FieldParseInfo(IsoType.ALPHA, 6));

		// RESPONSE CODE
		parseMap.put(39, new FieldParseInfo(IsoType.ALPHA, 2));

		// SERVICE RESTRICTION CODE
		parseMap.put(40, new FieldParseInfo(IsoType.ALPHA, 3));

		// CARD ACCEPTOR TERMINAL IDENTIFICACION
		parseMap.put(41, new FieldParseInfo(IsoType.ALPHA, 8));

		// CARD ACCEPTOR IDENTIFICATION CODE
		parseMap.put(42, new FieldParseInfo(IsoType.ALPHA, 15));

		// CARD ACCEPTOR NAME/LOCATION
		parseMap.put(43, new FieldParseInfo(IsoType.ALPHA, 40));

		// ADITIONAL RESPONSE DATA
		parseMap.put(44, new FieldParseInfo(IsoType.LLVAR, 25));

		// TRACK 1 DATA
		parseMap.put(45, new FieldParseInfo(IsoType.LLVAR, 76));

		// ADITIONAL DATA - ISO
		parseMap.put(46, new FieldParseInfo(IsoType.LLLVAR, 999));

		// ADITIONAL DATA - NATIONAL
		parseMap.put(47, new FieldParseInfo(IsoType.LLLVAR, 999));

		// ADITIONAL DATA - PRIVATE
		parseMap.put(48, new FieldParseInfo(IsoType.LLLVAR, 999));

		// CURRENCY CODE, TRANSACTION
		parseMap.put(49, new FieldParseInfo(IsoType.ALPHA, 3));

		// CURRENCY CODE, SETTLEMENT
		parseMap.put(50, new FieldParseInfo(IsoType.ALPHA, 3));

		// CURRENCY CODE, CARDHOLDER BILLING
		parseMap.put(51, new FieldParseInfo(IsoType.ALPHA, 3));

		// PIN DATA
		//parseMap.put(52, new FieldParseInfo(IsoType.org.jpos.iso.IFA_BINARY, 8));

		// SECURITY RELATED CONTROL INFORMATION
		parseMap.put(53, new FieldParseInfo(IsoType.NUMERIC, 16));

		// ADDITIONAL AMOUNTS
		parseMap.put(54, new FieldParseInfo(IsoType.LLLVAR, 120));

		// RESERVED ISO
		parseMap.put(55, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED ISO
		parseMap.put(56, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED NATIONAL
		parseMap.put(57, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED NATIONAL
		parseMap.put(58, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED NATIONAL
		parseMap.put(59, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE
		parseMap.put(60, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE
		parseMap.put(61, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE
		parseMap.put(62, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE
		parseMap.put(63, new FieldParseInfo(IsoType.LLLVAR, 999));

		// MESSAGE AUTHENTICATION CODE FIELD
		//parseMap.put(64, new FieldParseInfo(IsoType.org.jpos.iso.IFA_BINARY, 8));

		// BITMAP, EXTENDED
		//parseMap.put(65, new FieldParseInfo(IsoType.org.jpos.iso.IFA_BINARY, 1));

		// SETTLEMENT CODE
		parseMap.put(66, new FieldParseInfo(IsoType.NUMERIC, 1));

		// EXTENDED PAYMENT CODE
		parseMap.put(67, new FieldParseInfo(IsoType.NUMERIC, 2));

		// RECEIVING INSTITUTION COUNTRY CODE
		parseMap.put(68, new FieldParseInfo(IsoType.NUMERIC, 3));

		// SETTLEMENT INSTITUTION COUNTRY CODE
		parseMap.put(69, new FieldParseInfo(IsoType.NUMERIC, 3));

		// NETWORK MANAGEMENT INFORMATION CODE
		parseMap.put(70, new FieldParseInfo(IsoType.NUMERIC, 3));

		// MESSAGE NUMBER
		parseMap.put(71, new FieldParseInfo(IsoType.NUMERIC, 4));

		// MESSAGE NUMBER LAST
		parseMap.put(72, new FieldParseInfo(IsoType.NUMERIC, 4));

		// DATE ACTION
		parseMap.put(73, new FieldParseInfo(IsoType.NUMERIC, 6));

		// CREDITS NUMBER
		parseMap.put(74, new FieldParseInfo(IsoType.NUMERIC, 10));

		// CREDITS REVERSAL NUMBER
		parseMap.put(75, new FieldParseInfo(IsoType.NUMERIC, 10));

		// DEBITS NUMBER
		parseMap.put(76, new FieldParseInfo(IsoType.NUMERIC, 10));

		// DEBITS REVERSAL NUMBER
		parseMap.put(77, new FieldParseInfo(IsoType.NUMERIC, 10));

		// TRANSFER NUMBER
		parseMap.put(78, new FieldParseInfo(IsoType.NUMERIC, 10));

		// TRANSFER REVERSAL NUMBER
		parseMap.put(79, new FieldParseInfo(IsoType.NUMERIC, 10));

		// INQUIRIES NUMBER
		parseMap.put(80, new FieldParseInfo(IsoType.NUMERIC, 10));

		// AUTHORIZATION NUMBER
		parseMap.put(81, new FieldParseInfo(IsoType.NUMERIC, 10));

		// CREDITS, PROCESSING FEE AMOUNT
		parseMap.put(82, new FieldParseInfo(IsoType.NUMERIC, 12));

		// CREDITS, TRANSACTION FEE AMOUNT
		parseMap.put(83, new FieldParseInfo(IsoType.NUMERIC, 12));

		// DEBITS, PROCESSING FEE AMOUNT
		parseMap.put(84, new FieldParseInfo(IsoType.NUMERIC, 12));

		// DEBITS, TRANSACTION FEE AMOUNT
		parseMap.put(85, new FieldParseInfo(IsoType.NUMERIC, 12));

		// CREDITS, AMOUNT
		parseMap.put(86, new FieldParseInfo(IsoType.NUMERIC, 16));

		// CREDITS, REVERSAL AMOUNT
		parseMap.put(87, new FieldParseInfo(IsoType.NUMERIC, 16));

		// DEBITS, AMOUNT
		parseMap.put(88, new FieldParseInfo(IsoType.NUMERIC, 16));

		// DEBITS, REVERSAL AMOUNT
		parseMap.put(89, new FieldParseInfo(IsoType.NUMERIC, 16));

		// ORIGINAL DATA ELEMENTS
		parseMap.put(90, new FieldParseInfo(IsoType.NUMERIC, 42));

		// FILE UPDATE CODE
		parseMap.put(91, new FieldParseInfo(IsoType.ALPHA, 1));

		// FILE SECURITY CODE
		parseMap.put(92, new FieldParseInfo(IsoType.ALPHA, 2));

		// RESPONSE INDICATOR
		parseMap.put(93, new FieldParseInfo(IsoType.ALPHA, 6));

		// SERVICE INDICATOR
		parseMap.put(94, new FieldParseInfo(IsoType.ALPHA, 7));

		// REPLACEMENT AMOUNTS
		parseMap.put(95, new FieldParseInfo(IsoType.ALPHA, 42));

		// MESSAGE SECURITY CODE
		//parseMap.put(96, new FieldParseInfo(IsoType.org.jpos.iso.IFA_BINARY, 16));

		// AMOUNT, NET SETTLEMENT
		parseMap.put(97, new FieldParseInfo(IsoType.AMOUNT, 17));

		// PAYEE
		parseMap.put(98, new FieldParseInfo(IsoType.ALPHA, 25));

		// SETTLEMENT INSTITUTION IDENT CODE
		parseMap.put(99, new FieldParseInfo(IsoType.LLVAR, 11));

		// RECEIVING INSTITUTION IDENT CODE
		parseMap.put(100, new FieldParseInfo(IsoType.LLVAR, 11));

		// FILE NAME
		parseMap.put(101, new FieldParseInfo(IsoType.LLVAR, 17));

		// ACCOUNT IDENTIFICATION 1
		parseMap.put(102, new FieldParseInfo(IsoType.LLVAR, 28));

		// ACCOUNT IDENTIFICATION 2
		parseMap.put(103, new FieldParseInfo(IsoType.LLVAR, 28));

		// TRANSACTION DESCRIPTION
		parseMap.put(104, new FieldParseInfo(IsoType.LLLVAR, 100));

		// RESERVED ISO USE
		parseMap.put(105, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED ISO USE
		parseMap.put(106, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED ISO USE
		parseMap.put(107, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED ISO USE
		parseMap.put(108, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED ISO USE
		parseMap.put(109, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED ISO USE
		parseMap.put(110, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED ISO USE
		parseMap.put(111, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED NATIONAL USE
		parseMap.put(112, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED NATIONAL USE
		parseMap.put(113, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED NATIONAL USE
		parseMap.put(114, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED NATIONAL USE
		parseMap.put(115, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED NATIONAL USE
		parseMap.put(116, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED NATIONAL USE
		parseMap.put(117, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED NATIONAL USE
		parseMap.put(118, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED NATIONAL USE
		parseMap.put(119, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE USE
		parseMap.put(120, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE USE
		parseMap.put(121, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE USE
		parseMap.put(122, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE USE
		parseMap.put(123, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE USE
		parseMap.put(124, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE USE
		parseMap.put(125, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE USE
		parseMap.put(126, new FieldParseInfo(IsoType.LLLVAR, 999));

		// RESERVED PRIVATE USE
		parseMap.put(127, new FieldParseInfo(IsoType.LLLVAR, 999));

		// MAC 2
		//parseMap.put(128, new FieldParseInfo(IsoType.org.jpos.iso.IFA_BINARY, 8));
	}
	
	public HashMap<Integer, FieldParseInfo> getParseMap() {
		return parseMap;
	}

	public int getLength(int index) {
		FieldParseInfo info = parseMap.get(index);
		return info.getLength();
	}

	public IsoType getType(int index) {
		FieldParseInfo info = parseMap.get(index);
		return info.getType();
	}
	
}
