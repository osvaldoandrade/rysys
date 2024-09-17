package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.DoubleField;
import java.util.ArrayList;
import java.util.List;

@DataDescriptor
public class ExampleBeginIndex4 {

    @CollectionField(index = 1,
					totalLength=3,
					elementType=ExampleEntry.class,
					totalBeginIndex=-1,
					elementOffset=-10,
					direction=Direction.FROM_EIS)
	private List<ExampleEntry> list = new ArrayList<ExampleEntry>();

	@DoubleField(index = 2,
	             length=5,
				 precision=2,
				 direction=Direction.FROM_EIS)
	private double valor;

	public List<ExampleEntry> getList() {
		return list;
	}

	public void setList(List<ExampleEntry> list) {
		this.list = list;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
