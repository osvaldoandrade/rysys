package br.com.codecompany.rysys.iso8583.test.to;

import java.util.ArrayList;
import java.util.List;


public class SetorListaTO extends PaginacaoTO{
	
	private static final long serialVersionUID = -5758231209665682597L;
	private List<SetorTO> listaSetor = new ArrayList<SetorTO>();
	
	public List<SetorTO> getListaSetor() {
		return listaSetor;
	}
	public void setListaTpJuros(List<SetorTO> listaSetor) {
		this.listaSetor = listaSetor;
	}
}
