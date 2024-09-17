package br.com.codecompany.rysys.api.test.to;

import java.util.ArrayList;
import java.util.List;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;

@DataDescriptor
public class TipoJurosListaTO extends PaginacaoTO {

	private static final long serialVersionUID = -5758231209665682597L;

	@CollectionField(index = 1, 
			         elementType = TipoJurosTO.class, 
			         direction = Direction.FROM_EIS, 
			         totalBeginIndex = 0, 
			         totalLength = 2, 
			         elementOffset = 41)
	private List<TipoJurosTO> listaTpJuros = new ArrayList<TipoJurosTO>();

	public List<TipoJurosTO> getListaTpJuros() {
		return listaTpJuros;
	}

	public void setListaTpJuros(List<TipoJurosTO> listaTpJuros) {
		this.listaTpJuros = listaTpJuros;
	}
}
