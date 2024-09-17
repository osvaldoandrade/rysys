package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@DataDescriptor
public class ExampleCollection2 {
	@CollectionField(index = 1,                         // TO_EIS
	                 elementType = String.class,        // FROM_EIS/TO_EIS
	                 direction = Direction.FROM_TO_EIS, // FROM_EIS
	                 totalBeginIndex = 33,              // FROM_EIS
	                 totalLength = 1,                   // FROM_EIS/TO_EIS
	                 elementOffset = 6,                 // FROM_EIS/TO_EIS
                     appendTotal=false
	)
	private List<String> list = new ArrayList<String>();

	@CollectionField(index = 2,                         // TO_EIS
	                 elementType = BigDecimal.class,    // FROM_EIS/TO_EIS
	                 direction = Direction.FROM_TO_EIS, // FROM_EIS
	                 totalBeginIndex = 0,               // FROM_EIS
	                 totalLength = 1,                   // FROM_EIS/TO_EIS
	                 elementOffset = 10,                // FROM_EIS/TO_EIS
	                 collectionStart = 3                // FROM_EIS
	)
	private List<BigDecimal> list2 = new ArrayList<BigDecimal>();

	public List<String> getList() {
		return list;
	}

	public List<BigDecimal> getList2() {
		return list2;
	}
}
