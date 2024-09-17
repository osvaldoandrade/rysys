package br.com.codecompany.rysys.iso8583.test.to;

import java.util.ArrayList;
import java.util.List;


public class TitulosLiquidadosListaTO extends PaginacaoTO {

	private static final long serialVersionUID = -6717291180320474511L;
	
	private String nomeUnidadeVinculacao;
	private String dtPagamento;
	
	private List<TitulosLiquidadosTO> listaTitulosLiquidados =  new ArrayList<TitulosLiquidadosTO>();
	
	public List<TitulosLiquidadosTO> getListaTitulosLiquidados() {
		return listaTitulosLiquidados;
	}
	public void setListaTitulosLiquidados(
			List<TitulosLiquidadosTO> listaTitulosLiquidados) {
		this.listaTitulosLiquidados = listaTitulosLiquidados;
	}
	public String getNomeUnidadeVinculacao() {
		return nomeUnidadeVinculacao;
	}
	public void setNomeUnidadeVinculacao(String nomeUnidadeVinculacao) {
		this.nomeUnidadeVinculacao = nomeUnidadeVinculacao;
	}
	public String getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(String dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

}
