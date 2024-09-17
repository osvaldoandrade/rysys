package br.com.codecompany.rysys.api.test.annotation;

import junit.framework.Assert;

import org.junit.Test;

import br.com.codecompany.rysys.api.test.ExampleCollection;
import br.com.codecompany.rysys.api.test.ExampleCollection2;
import br.com.codecompany.rysys.api.test.ExampleEntry;
import br.com.codecompany.rysys.api.test.ExampleEntry2;
import br.com.codecompany.rysys.api.test.ExampleCollection3;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class TestCollectionFieldAnnotation extends TestHelper {
	
	//@Test
	public void extractPrimitiveData() {
		ExampleCollection pojo = new ExampleCollection();
		
		pojo.getList().add(1);
		pojo.getList().add(3);
		pojo.getList().add(2);

		pojo.getList2().add(new ExampleEntry("x", 6));
		pojo.getList2().add(new ExampleEntry("y", 7));
		
		String expected = "313226x        7y        ";
		Assert.assertEquals(expected, helper.extractFieldsAsString(pojo));
	}
	
	@Test
	public void populatePrimitiveData() {
		String response = "3  1ANDRE    2DANTAS   3ROCHA    3123";
		ExampleCollection pojo = new ExampleCollection();
		helper.populateFields(pojo, response);
		
		Assert.assertEquals(3, pojo.getList().size());
		Assert.assertEquals(new Integer(1), pojo.getList().get(0));
		Assert.assertEquals(new Integer(2), pojo.getList().get(1));
		Assert.assertEquals(new Integer(3), pojo.getList().get(2));
		
		Assert.assertEquals(3, pojo.getList2().size());
		
		ExampleEntry entry0 = pojo.getList2().get(0);
		Assert.assertEquals(1, entry0.getValue());
		Assert.assertEquals("ANDRE", entry0.getName());
		
		ExampleEntry entry1 = pojo.getList2().get(1);
		Assert.assertEquals(2, entry1.getValue());
		Assert.assertEquals("DANTAS", entry1.getName());		

		ExampleEntry entry2 = pojo.getList2().get(2);
		Assert.assertEquals(3, entry2.getValue());
		Assert.assertEquals("ROCHA", entry2.getName());
	}

    //@Test
    public void extractWithWithoutTotal() {
        ExampleCollection2 pojo = new ExampleCollection2();

		pojo.getList().add("ANDRE");
		pojo.getList().add("DANTAS");
		pojo.getList().add("ROCHA");

		pojo.getList2().add(new BigDecimal(1));
		pojo.getList2().add(new BigDecimal(2));

		String expected = "ANDRE DANTASROCHA 200000000010000000002";
		Assert.assertEquals(expected, helper.extractFieldsAsString(pojo));
    }

	//@Test
	public void extractWithIntermediatePosition() {
		ExampleCollection3 dto = new ExampleCollection3();
		dto.setCodigo(2);
		dto.setData(new Date());
		dto.setDescricao("TESTE DTO");
		dto.setValor(123.66);
		dto.setFlagConfissaoDivida("F");

		Calendar c1 = Calendar.getInstance();
		c1.set(2009, Calendar.OCTOBER, 30);

		dto.setData(new Date(c1.getTimeInMillis()));

		dto.getList().add(new ExampleEntry2(1, "TESTE"));
		dto.getList().add(new ExampleEntry2(2, "ANDRE"));

		String result = helper.extractFieldsAsString(dto);
		String expected = "00002" +
				"TESTE DTO " +
				"20091030" +
				"012366" +
				"02" +
				"01TESTE   " +
				"02ANDRE   " +
				"F";

		Assert.assertEquals(expected, result);
	}
}
