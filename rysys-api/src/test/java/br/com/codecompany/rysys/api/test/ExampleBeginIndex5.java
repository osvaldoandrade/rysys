package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.FloatField;
import java.util.ArrayList;
import java.util.List;

@DataDescriptor
public class ExampleBeginIndex5 {

	@CollectionField(index = 1,
	                 elementType = Integer.class,
	                 direction = Direction.FROM_TO_EIS,
	                 totalBeginIndex = -30, // sera ignorado
	                 totalLength = 2,
	                 elementOffset = 10
	)
	private List<Integer> list = new ArrayList<Integer>();

	@CollectionField(index = 2,
	                 elementType = String.class,
	                 direction = Direction.FROM_TO_EIS,
	                 totalBeginIndex = -30, // sera ignorado
	                 totalLength = 3,
	                 elementOffset = 6
	)
	private List<String> list2 = new ArrayList<String>();
	
	public List<Integer> getList() {
		return list;
	}

    public List<String> getList2() {
        return list2;
    }

}
