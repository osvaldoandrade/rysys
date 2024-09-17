package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import java.util.ArrayList;
import java.util.List;

@DataDescriptor
public class ExampleCollection4 {

	@IntegerField(index=1, length=1, direction = Direction.FROM_TO_EIS)
	private int sizeList;

	@IntegerField(index=2, length=1, direction = Direction.FROM_TO_EIS)
	private int sizeList2;

	@CollectionField(index = 3,                         // TO_EIS
	                 elementType = Integer.class,       // FROM_EIS/TO_EIS
	                 direction = Direction.FROM_TO_EIS, // FROM_EIS
	                 totalBeginIndex = -1,              // FROM_EIS
	                 totalLength = -1,                   // FROM_EIS/TO_EIS
	                 elementOffset = 1,                  // FROM_EIS
					 totalFromProperty="sizeList"
	)
	private List<Integer> list = new ArrayList<Integer>();

	@CollectionField(index = 4,                                    // TO_EIS
	                 elementType = ExampleEntry.class, // FROM_EIS/TO_EIS
	                 direction = Direction.FROM_TO_EIS,            // FROM_EIS
	                 totalBeginIndex = -1,                          // FROM_EIS
	                 totalLength = -1,                              // FROM_EIS/TO_EIS
	                 elementOffset = 10,                           // FROM_EIS
					 totalFromProperty="sizeList2"
	)
	private List<ExampleEntry> list2 = new ArrayList<ExampleEntry>();

	public int getSizeList() {
		return sizeList;
	}

	public void setSizeList(int sizeList) {
		this.sizeList = sizeList;
	}

	public int getSizeList2() {
		return sizeList2;
	}

	public void setSizeList2(int sizeList2) {
		this.sizeList2 = sizeList2;
	}
	
	public List<Integer> getList() {
		return list;
	}

	public List<ExampleEntry> getList2() {
		return list2;
	}
}
