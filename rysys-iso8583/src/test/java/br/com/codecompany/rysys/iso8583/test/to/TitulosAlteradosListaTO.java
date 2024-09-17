package br.com.codecompany.rysys.iso8583.test.to;

import java.util.ArrayList;
import java.util.List;


public class TitulosAlteradosListaTO extends PaginacaoTO {

	private static final long serialVersionUID = 8542109212576031611L;
	
	private String nomeUnidadePv;
	
	private List<TitulosAlteradosTO> listaTitulosAlterados =  new ArrayList<TitulosAlteradosTO>();


	public List<TitulosAlteradosTO> getListaTitulosAlterados() {
		return listaTitulosAlterados;
	}

	public void setListaTitulosAlterados(List<TitulosAlteradosTO> listaTitulosAlterados) {
		this.listaTitulosAlterados = listaTitulosAlterados;
	}

	public String getNomeUnidadePv() {
		return nomeUnidadePv;
	}

	public void setNomeUnidadePv(String nomeUnidadePv) {
		this.nomeUnidadePv = nomeUnidadePv;
	}


}
