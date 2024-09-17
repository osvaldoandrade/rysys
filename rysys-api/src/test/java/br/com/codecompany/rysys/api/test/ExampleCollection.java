package br.com.codecompany.rysys.api.test;

import java.util.ArrayList;
import java.util.List;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;

@DataDescriptor
public class ExampleCollection {
	@CollectionField(index = 1,                         // TO_EIS
	                 elementType = Integer.class,       // FROM_EIS/TO_EIS
	                 direction = Direction.FROM_TO_EIS, // FROM_EIS
	                 totalBeginIndex = 33,              // FROM_EIS
	                 totalLength = 1,                   // FROM_EIS/TO_EIS
	                 elementOffset = 1                  // FROM_EIS
	)
	private List<Integer> list = new ArrayList<Integer>();

	@CollectionField(index = 2,                                    // TO_EIS
	                 elementType = ExampleEntry.class, // FROM_EIS/TO_EIS
	                 direction = Direction.FROM_TO_EIS,            // FROM_EIS 
	                 totalBeginIndex = 0,                          // FROM_EIS
	                 totalLength = 1,                              // FROM_EIS/TO_EIS
	                 elementOffset = 10,                           // FROM_EIS
	                 collectionStart = 3                           // FROM_EIS
	)
	private List<ExampleEntry> list2 = new ArrayList<ExampleEntry>();

	public List<Integer> getList() {
		return list;
	}

	public List<ExampleEntry> getList2() {
		return list2;
	}
}
