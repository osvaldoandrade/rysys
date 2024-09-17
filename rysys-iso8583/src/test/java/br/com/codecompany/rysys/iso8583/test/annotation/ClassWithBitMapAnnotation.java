package br.com.codecompany.rysys.iso8583.test.annotation;

import br.com.codecompany.rysys.iso8583.annotation.Iso8583Bit;
import br.com.codecompany.rysys.iso8583.annotation.Iso8583BitMap;

@Iso8583BitMap
public class ClassWithBitMapAnnotation {

	@Iso8583Bit(0)
	public static final String field0 = "0205";
	
	@Iso8583Bit(11)
	public static final String field1 = "field11";
	
	@Iso8583Bit(12)
	public static final String field2 = "field12";
	
	@Iso8583Bit(13)
	public static final String field3 = "field13";
}
