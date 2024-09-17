package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.DoubleField;
import java.util.ArrayList;
import java.util.List;

@DataDescriptor
public class ExampleBeginIndex3 {

	@DoubleField(index = 1,
	             length=5,
				 precision=2,
				 direction=Direction.FROM_EIS)
	private double valor;

	@CollectionField(index = 2,
					totalLength=3,
					elementType=ExampleEntry.class,
					totalBeginIndex=-1,
					elementOffset=3, // sera ignorado
					direction=Direction.FROM_EIS)
	private List<ExampleEntry> list = new ArrayList<ExampleEntry>();

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
