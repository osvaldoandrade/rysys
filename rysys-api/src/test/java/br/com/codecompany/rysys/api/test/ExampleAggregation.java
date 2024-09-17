package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.AggregationField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.FloatField;
import br.com.codecompany.rysys.api.annotation.core.TextField;

@DataDescriptor
public class ExampleAggregation {

    @FloatField(index=1,
                beginIndex=0,
                length=7,
                precision=3,
                direction=Direction.FROM_TO_EIS)
    private float number;

    @AggregationField(index=2,
                      beginIndex=8,
                      type=ExampleAggregationField.class,
                      direction=Direction.FROM_TO_EIS)
    private ExampleAggregationField aggregationField;

    @TextField(index=3,
               length=8,
               beginIndex=17,
               direction=Direction.FROM_TO_EIS)
    private String value;

    public ExampleAggregationField getAggregationField() {
        return aggregationField;
    }

    public void setAggregationField(ExampleAggregationField aggregationField) {
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
