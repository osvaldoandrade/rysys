package br.com.codecompany.rysys.api.test.annotation;

import br.com.codecompany.rysys.api.test.ExampleDate2;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;

public class TestForceDateZeroToNull extends TestHelper {

	@Test
	public void withoutForcingNull() {
		String response = "0000000000000000";
		ExampleDate2 pojo = new ExampleDate2();
		helper.populateFields(pojo, response);

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(pojo.getDate1());
		Assert.assertEquals(30, calendar1.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(Calendar.NOVEMBER, calendar1.get(Calendar.MONTH));
		Assert.assertEquals(2, calendar1.get(Calendar.YEAR));
	}

	@Test
	public void forcingNull() {
		String response = "0000000000000000";
		ExampleDate2 pojo = new ExampleDate2();
		helper.populateFields(pojo, response);
		
		Assert.assertEquals(null, pojo.getDate2());
	}
}
