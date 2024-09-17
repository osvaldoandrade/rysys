package br.com.codecompany.rysys.iso8583.test.to;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ProtestoTitulosListaTO extends PaginacaoTO{

	private static final long serialVersionUID = 7739135397400401632L;
	
	private String nomeUnidade;
    private long totalTitulos;
    private BigDecimal vlrTotalTitulos;
    
    private List<ProtestoTitulosTO> listaProtestoTitulos =  new ArrayList<ProtestoTitulosTO>();

	public String getNomeUnidade() {
		return Formatador.toUpperCase(nomeUnidade);
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public long getTotalTitulos() {
		return totalTitulos;
	}

	public void setTotalTitulos(long totalTitulos) {
		this.totalTitulos = totalTitulos;
	}

	public BigDecimal getVlrTotalTitulos() {
		return vlrTotalTitulos;
	}

	public void setVlrTotalTitulos(BigDecimal vlrTotalTitulos) {
		this.vlrTotalTitulos = vlrTotalTitulos;
	}

	public List<ProtestoTitulosTO> getListaProtestoTitulos() {
		return listaProtestoTitulos;
	}

	public void setListaProtestoTitulos(List<ProtestoTitulosTO> listaProtestoTitulos) {
		this.listaProtestoTitulos = listaProtestoTitulos;
	}
    
	public String getVlrTotalTituloFormatado(){
		return Formatador.formatarValorEmReais(this.vlrTotalTitulos);
	}
    
    
}
