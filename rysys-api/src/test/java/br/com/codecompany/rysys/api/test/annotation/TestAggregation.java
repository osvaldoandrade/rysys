package br.com.codecompany.rysys.api.test.annotation;

import br.com.codecompany.rysys.api.test.ExampleAggregation;
import br.com.codecompany.rysys.api.test.ExampleAggregationField;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class TestAggregation extends TestHelper {

    @Test
    public void extractAggregation() {
        ExampleAggregation pojo = new ExampleAggregation();
        ExampleAggregationField aggregationField = new ExampleAggregationField();
        aggregationField.setDecimalProperty(new BigDecimal(35.67));
        aggregationField.setStringProperty("ABC");

        pojo.setAggregationField(aggregationField);
        pojo.setValue("ANDRE");
        pojo.setNumber(897.678f);

        String request = helper.extractFieldsAsString(pojo);
        Assert.assertEquals("0897678ABC 003567ANDRE   ", request);
    }

    @Test
    public void populateAggregation() {
        String response = "0897678ABC 003567ANDRE   ";
        ExampleAggregation pojo = new ExampleAggregation();
        helper.populateFields(pojo, response);

        Assert.assertEquals("ANDRE", pojo.getValue());
        Assert.assertEquals(897.678f, pojo.getNumber());
        Assert.assertEquals(new BigDecimal(35.67), 
                pojo.getAggregationField().getDecimalProperty());
        Assert.assertEquals("ABC",
                pojo.getAggregationField().getStringProperty());
    }
}
