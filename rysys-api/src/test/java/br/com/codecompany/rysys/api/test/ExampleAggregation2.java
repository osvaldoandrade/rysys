package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.AggregationField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.FloatField;
import br.com.codecompany.rysys.api.annotation.core.TextField;

@DataDescriptor
public class ExampleAggregation2 {

    @FloatField(index=1,
                beginIndex=-30,
                length=7,
                precision=3,
                direction=Direction.FROM_TO_EIS)
    private float number;

    @AggregationField(index=2,
                      beginIndex=-50,
                      type=ExampleAggregationField2.class,
                      direction=Direction.FROM_TO_EIS)
    private ExampleAggregationField2 aggregationField;

    @TextField(index=3,
               length=8,
               beginIndex=-100,
               direction=Direction.FROM_TO_EIS)
    private String value;

    public ExampleAggregationField2 getAggregationField() {
        return aggregationField;
    }

    public void setAggregationField(ExampleAggregationField2 aggregationField) {
        this.aggregationField = aggregationField;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
