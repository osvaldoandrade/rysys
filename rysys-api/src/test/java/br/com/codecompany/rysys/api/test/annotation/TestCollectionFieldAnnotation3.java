package br.com.codecompany.rysys.api.test.annotation;

import br.com.codecompany.rysys.api.test.ExampleCollection4;
import br.com.codecompany.rysys.api.test.ExampleCollection5;
import br.com.codecompany.rysys.api.test.ExampleCollection6;
import br.com.codecompany.rysys.api.test.ExampleEntry;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class TestCollectionFieldAnnotation3 extends TestHelper {

	@Test
	public void totalIndexFromProperty() {
		ExampleCollection4 pojo = new ExampleCollection4();
		String request = "23561ANDRE    2DANTAS   3ROCHA    ";
		helper.setAutoCalculateBeginIndex(true);
		helper.populateFields(pojo, request);

		Assert.assertEquals(2, pojo.getSizeList());
		Assert.assertEquals(3, pojo.getSizeList2());

		Assert.assertEquals(2, pojo.getList().size());
		Assert.assertEquals(5, pojo.getList().get(0));
		Assert.assertEquals(6, pojo.getList().get(1));

		Assert.assertEquals(2, pojo.getList().size());
		Assert.assertEquals(3, pojo.getList2().size());

		ExampleEntry entry1 = pojo.getList2().get(0);
		Assert.assertEquals(1, entry1.getValue());
		Assert.assertEquals("ANDRE", entry1.getName());

		ExampleEntry entry2 = pojo.getList2().get(1);
		Assert.assertEquals(2, entry2.getValue());
		Assert.assertEquals("DANTAS", entry2.getName());

		ExampleEntry entry3 = pojo.getList2().get(2);
		Assert.assertEquals(3, entry3.getValue());
		Assert.assertEquals("ROCHA", entry3.getName());
	}

	@Test
	public void totalIndexFromProperty2() {
		ExampleCollection5 pojo = new ExampleCollection5();
		String request = "321ANDRE    2DANTAS   3ROCHA    56";
		helper.setAutoCalculateBeginIndex(true);
		helper.populateFields(pojo, request);

		Assert.assertEquals(2, pojo.getSizeList());
		Assert.assertEquals(3, pojo.getSizeList2());

		Assert.assertEquals(2, pojo.getList().size());
		Assert.assertEquals(5, pojo.getList().get(0));
		Assert.assertEquals(6, pojo.getList().get(1));

		Assert.assertEquals(2, pojo.getList().size());
		Assert.assertEquals(3, pojo.getList2().size());

		ExampleEntry entry1 = pojo.getList2().get(0);
		Assert.assertEquals(1, entry1.getValue());
		Assert.assertEquals("ANDRE", entry1.getName());

		ExampleEntry entry2 = pojo.getList2().get(1);
		Assert.assertEquals(2, entry2.getValue());
		Assert.assertEquals("DANTAS", entry2.getName());

		ExampleEntry entry3 = pojo.getList2().get(2);
		Assert.assertEquals(3, entry3.getValue());
		Assert.assertEquals("ROCHA", entry3.getName());
	}

    @Test
    public void totalIndexFromProperty3() {
        String response = "321ANDRE    2DANTAS   3ROCHA    " +
				"ABC 00356756";
        ExampleCollection6 pojo = new ExampleCollection6();
		helper.setAutoCalculateBeginIndex(true);
        helper.populateFields(pojo, response);

		Assert.assertEquals(2, pojo.getSizeList());
		Assert.assertEquals(3, pojo.getSizeList2());

		Assert.assertEquals(2, pojo.getList().size());
		Assert.assertEquals(5, pojo.getList().get(0));
		Assert.assertEquals(6, pojo.getList().get(1));

        Assert.assertEquals(new BigDecimal(35.67),
                pojo.getAggregationField().getDecimalProperty());
        Assert.assertEquals("ABC",
                pojo.getAggregationField().getStringProperty());

		Assert.assertEquals(2, pojo.getList().size());
		Assert.assertEquals(3, pojo.getList2().size());

		ExampleEntry entry1 = pojo.getList2().get(0);
		Assert.assertEquals(1, entry1.getValue());
		Assert.assertEquals("ANDRE", entry1.getName());

		ExampleEntry entry2 = pojo.getList2().get(1);
		Assert.assertEquals(2, entry2.getValue());
		Assert.assertEquals("DANTAS", entry2.getName());

		ExampleEntry entry3 = pojo.getList2().get(2);
		Assert.assertEquals(3, entry3.getValue());
		Assert.assertEquals("ROCHA", entry3.getName());
    }
}
