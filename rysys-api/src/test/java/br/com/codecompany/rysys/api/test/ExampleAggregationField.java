package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.BigDecimalField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.TextField;
import java.math.BigDecimal;

@DataDescriptor
public class ExampleAggregationField {

    @TextField(length=4,
               index=1,
               beginIndex=0,
               direction=Direction.FROM_TO_EIS)
	private String stringProperty;

	@BigDecimalField(length=6, 
                     index=2,
                     beginIndex=4,
                     precision=2,
                     direction=Direction.FROM_TO_EIS)
	private BigDecimal decimalProperty;

    public BigDecimal getDecimalProperty() {
        return decimalProperty;
    }

    public void setDecimalProperty(BigDecimal decimalProperty) {
        this.decimalProperty = decimalProperty;
    }

    public String getStringProperty() {
        return stringProperty;
    }

    public void setStringProperty(String stringProperty) {
        this.stringProperty = stringProperty;
    }
}
