package br.com.codecompany.rysys.iso8583.test.annotation;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.codecompany.rysys.api.annotation.ClassNotAnnotatedException;
import br.com.codecompany.rysys.iso8583.annotation.helper.BitMapHelper;
import br.com.codecompany.rysys.iso8583.driver.Iso8583Adapter;
import br.com.codecompany.rysys.iso8583.sirot.SirotAdapter;

import com.solab.iso8583.IsoMessage;

public class TestIso8583BitAnnotation {
	
	private Iso8583Adapter adapter = new SirotAdapter();
	
	private IsoMessage extract(Object bitMapObject) {
		Map<Integer, String> map = BitMapHelper.extractBitMap(bitMapObject);
		return adapter.createMessage(map);
	}
	
	@Test
	public void annotatedClass() {
		ClassWithBitMapAnnotation annotated = new ClassWithBitMapAnnotation();
		IsoMessage msg = extract(annotated);
		Assert.assertEquals("field11", String.valueOf(msg.getObjectValue(11)));
		Assert.assertEquals("field12", String.valueOf(msg.getObjectValue(12)));
		Assert.assertEquals("field13", String.valueOf(msg.getObjectValue(13)));
	}

	@Test(expected = ClassNotAnnotatedException.class)
	public void nonAnnotatedClass() {
		ClassWithoutBitMapAnnotation nonAnnotated = new ClassWithoutBitMapAnnotation();
		IsoMessage msg = extract(nonAnnotated);
		Assert.assertEquals(null, msg.getObjectValue(11));
		Assert.assertEquals(null, msg.getObjectValue(12));
		Assert.assertEquals(null, msg.getObjectValue(13));
	}
	
	public static void main(String[] args) {
		new TestIso8583BitAnnotation().annotatedClass();
	}
}
