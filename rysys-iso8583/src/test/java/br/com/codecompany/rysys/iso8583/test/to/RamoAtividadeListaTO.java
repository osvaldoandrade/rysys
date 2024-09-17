package br.com.codecompany.rysys.iso8583.test.to;

import java.util.ArrayList;
import java.util.List;


public class RamoAtividadeListaTO extends PaginacaoTO{
	
	private static final long serialVersionUID = 7757899893406662510L;
	
	private List<RamoAtividadeTO> listaRamoAtividade = new ArrayList<RamoAtividadeTO>();

	public List<RamoAtividadeTO> getListaRamoAtividade() {
		return listaRamoAtividade;
	}

	public void setListaRamoAtividade(List<RamoAtividadeTO> listaRamoAtividade) {
		this.listaRamoAtividade = listaRamoAtividade;
	}
}
