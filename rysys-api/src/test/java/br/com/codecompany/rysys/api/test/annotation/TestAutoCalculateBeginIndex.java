package br.com.codecompany.rysys.api.test.annotation;

import br.com.codecompany.rysys.api.test.ExampleAggregation2;
import br.com.codecompany.rysys.api.test.ExampleBeginIndex;
import br.com.codecompany.rysys.api.test.ExampleBeginIndex2;
import br.com.codecompany.rysys.api.test.ExampleBeginIndex3;
import br.com.codecompany.rysys.api.test.ExampleBeginIndex4;
import br.com.codecompany.rysys.api.test.ExampleBeginIndex5;
import br.com.codecompany.rysys.api.test.ExampleBeginIndex6;
import br.com.codecompany.rysys.api.test.ExampleEntry;
import br.com.codecompany.rysys.api.test.ExampleEntry2;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class TestAutoCalculateBeginIndex extends TestHelper {

	@Test
	public void simpleCollectionAndFloat() {
		String response = "3ANDRE DANTASROCHA 123";
		ExampleBeginIndex pojo = new ExampleBeginIndex();
		helper.setAutoCalculateBeginIndex(true);
		helper.populateFields(pojo, response);

		Assert.assertEquals("ANDRE", pojo.getList().get(0));
		Assert.assertEquals("DANTAS", pojo.getList().get(1));
		Assert.assertEquals("ROCHA", pojo.getList().get(2));
		Assert.assertEquals(123f, pojo.getFloatProperty());
	}

	@Test
	public void floatAndSimpleCollection() {
		String response = "1233ANDRE DANTASROCHA ";
		ExampleBeginIndex2 pojo = new ExampleBeginIndex2();
		helper.setAutoCalculateBeginIndex(true);
		helper.populateFields(pojo, response);

		Assert.assertEquals("ANDRE", pojo.getList().get(0));
		Assert.assertEquals("DANTAS", pojo.getList().get(1));
		Assert.assertEquals("ROCHA", pojo.getList().get(2));
		Assert.assertEquals(123f, pojo.getFloatProperty());
	}

	@Test
	public void doubleAndComplexCollection() {
		String response = "025630031ANDRE    2DANTAS   3ROCHA    ";
		ExampleBeginIndex3 pojo = new ExampleBeginIndex3();
		helper.setAutoCalculateBeginIndex(true);
		helper.populateFields(pojo, response);

        Assert.assertEquals(25.63D, pojo.getValor());

		ExampleEntry entry0 = pojo.getList().get(0);
		Assert.assertEquals(1, entry0.getValue());
		Assert.assertEquals("ANDRE", entry0.getName());

		ExampleEntry entry1 = pojo.getList().get(1);
		Assert.assertEquals(2, entry1.getValue());
		Assert.assertEquals("DANTAS", entry1.getName());

		ExampleEntry entry2 = pojo.getList().get(2);
		Assert.assertEquals(3, entry2.getValue());
		Assert.assertEquals("ROCHA", entry2.getName());
	}

	@Test
	public void complexCollectionAndDouble() {
		String response = "0031ANDRE    2DANTAS   3ROCHA    02563";
		ExampleBeginIndex4 pojo = new ExampleBeginIndex4();
		helper.setAutoCalculateBeginIndex(true);
		helper.populateFields(pojo, response);

        Assert.assertEquals(25.63D, pojo.getValor());

		ExampleEntry entry0 = pojo.getList().get(0);
		Assert.assertEquals(1, entry0.getValue());
		Assert.assertEquals("ANDRE", entry0.getName());

		ExampleEntry entry1 = pojo.getList().get(1);
		Assert.assertEquals(2, entry1.getValue());
		Assert.assertEquals("DANTAS", entry1.getName());

		ExampleEntry entry2 = pojo.getList().get(2);
		Assert.assertEquals(3, entry2.getValue());
		Assert.assertEquals("ROCHA", entry2.getName());
    }

	@Test
	public void twoSimpleCollections() {
		String response = "0200000123450000067890003ANDRE DANTASROCHA ";
		ExampleBeginIndex5 pojo = new ExampleBeginIndex5();
		helper.setAutoCalculateBeginIndex(true);
		helper.populateFields(pojo, response);

		Assert.assertEquals(12345, pojo.getList().get(0));
		Assert.assertEquals(67890, pojo.getList().get(1));

		Assert.assertEquals("ANDRE", pojo.getList2().get(0));
		Assert.assertEquals("DANTAS", pojo.getList2().get(1));
		Assert.assertEquals("ROCHA", pojo.getList2().get(2));
    }

	@Test
	public void twoComplexCollections() {
        String response = "0031ANDRE    2DANTAS   3ROCHA    207andre   08dantas  ";
		ExampleBeginIndex6 pojo = new ExampleBeginIndex6();
		helper.setAutoCalculateBeginIndex(true);
		helper.populateFields(pojo, response);

        ExampleEntry entry1 = pojo.getList().get(0);
        Assert.assertEquals(1, entry1.getValue());
		Assert.assertEquals("ANDRE", entry1.getName());

        ExampleEntry entry2 = pojo.getList().get(1);
        Assert.assertEquals(2, entry2.getValue());
        Assert.assertEquals("DANTAS", entry2.getName());

        ExampleEntry entry3 = pojo.getList().get(2);
        Assert.assertEquals(3, entry3.getValue());
        Assert.assertEquals("ROCHA", entry3.getName());

        ExampleEntry2 entry4 = pojo.getList2().get(0);
        Assert.assertEquals(7, entry4.getCodigo());
        Assert.assertEquals("andre", entry4.getDescricao());

        ExampleEntry2 entry5 = pojo.getList2().get(1);
        Assert.assertEquals(8, entry5.getCodigo());
        Assert.assertEquals("dantas", entry5.getDescricao());
    }

    @Test
    public void aggregateField() {
        String response = "0897678ABC 003567ANDRE   ";
        ExampleAggregation2 pojo = new ExampleAggregation2();
        helper.setAutoCalculateBeginIndex(true);
        helper.populateFields(pojo, response);

        Assert.assertEquals("ANDRE", pojo.getValue());
        Assert.assertEquals(897.678f, pojo.getNumber());
        Assert.assertEquals(new BigDecimal(35.67),
                pojo.getAggregationField().getDecimalProperty());
        Assert.assertEquals("ABC",
                pojo.getAggregationField().getStringProperty());
    }
}
