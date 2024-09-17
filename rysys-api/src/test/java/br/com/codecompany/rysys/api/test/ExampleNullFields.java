package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.BigDecimalField;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.DateField;
import br.com.codecompany.rysys.api.annotation.core.DoubleField;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.TextField;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@DataDescriptor
public class ExampleNullFields {

	@DateField(length=10, index=1, direction=Direction.FROM_TO_EIS)
	private Date dateProperty = null;

	@TextField(index = 2, length = 8)
	private String stringProperty = null;

	@CollectionField(index = 3,
	                 elementType = String.class,
	                 direction = Direction.FROM_TO_EIS,
	                 totalBeginIndex = 33,
	                 totalLength = 1,
	                 elementOffset = 1
	)
	private List<String> collectionProperty = null;

	@DoubleField(length=5, index=4, precision=2, direction=Direction.FROM_TO_EIS)
	private Double doubleProperty = null;

	@IntegerField(length=7, index=5, direction=Direction.FROM_TO_EIS)
	private Integer integerProperty = null;

	@BigDecimalField(length=6, index=6, precision=2, direction=Direction.FROM_TO_EIS)
	private BigDecimal bigDecimalProperty = null;

	public BigDecimal getBigDecimalProperty() {
		return bigDecimalProperty;
	}

	public void setBigDecimalProperty(BigDecimal bigDecimalProperty) {
		this.bigDecimalProperty = bigDecimalProperty;
	}

	public List<String> getCollectionProperty() {
		return collectionProperty;
	}

	public void setCollectionProperty(List<String> collectionProperty) {
		this.collectionProperty = collectionProperty;
	}

	public Date getDateProperty() {
		return dateProperty;
	}

	public void setDateProperty(Date dateProperty) {
		this.dateProperty = dateProperty;
	}

	public Double getDoubleProperty() {
		return doubleProperty;
	}

	public void setDoubleProperty(Double doubleProperty) {
		this.doubleProperty = doubleProperty;
	}

	public Integer getIntegerProperty() {
		return integerProperty;
	}

	public void setIntegerProperty(Integer integerProperty) {
		this.integerProperty = integerProperty;
	}

	public String getStringProperty() {
		return stringProperty;
	}

	public void setStringProperty(String stringProperty) {
		this.stringProperty = stringProperty;
	}
}
