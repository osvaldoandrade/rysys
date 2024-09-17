package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import java.util.ArrayList;
import java.util.List;

@DataDescriptor
public class ExampleBeginIndex6 {

    @CollectionField(index = 1,
					totalLength=3,
					elementType=ExampleEntry.class,
					totalBeginIndex=-1,
					elementOffset=-1,
					direction=Direction.FROM_EIS)
	private List<ExampleEntry> list = new ArrayList<ExampleEntry>();

	@CollectionField(index = 2,
					totalLength=1,
					elementType=ExampleEntry2.class,
					totalBeginIndex=-1,
					elementOffset=-1,
					direction=Direction.FROM_EIS)
	private List<ExampleEntry2> list2 = new ArrayList<ExampleEntry2>();

    public List<ExampleEntry> getList() {
        return list;
    }

    public List<ExampleEntry2> getList2() {
        return list2;
    }
}
