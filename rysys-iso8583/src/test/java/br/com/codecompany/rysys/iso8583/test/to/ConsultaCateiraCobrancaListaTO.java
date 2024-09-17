package br.com.codecompany.rysys.iso8583.test.to;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ConsultaCateiraCobrancaListaTO extends PaginacaoTO{
	
	private static final long serialVersionUID = -25910028012828916L;
	
	private String situacao;
	private int totalVencidosQtde;
	private BigDecimal totalVencidosValor;
	private int totalVencendoDiaQtde;
	private BigDecimal totalVencendoDiaValor;
	private int totalVencerQtde;
	private BigDecimal totalVencerValor;
	private int totalLiquidadosDiaQtde;
	private BigDecimal totalLiquidadosDiaValor;

	
	private List<ConsultaCateiraCobrancaTO> listaCarteiraCobranca = new ArrayList<ConsultaCateiraCobrancaTO>();


	public List<ConsultaCateiraCobrancaTO> getListaCarteiraCobranca() {
		return listaCarteiraCobranca;
	}


	public void setListaCarteiraCobranca(
			List<ConsultaCateiraCobrancaTO> listaCarteiraCobranca) {
		this.listaCarteiraCobranca = listaCarteiraCobranca;
	}	
	
	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	public int getTotalVencidosQtde() {
		return totalVencidosQtde;
	}


	public void setTotalVencidosQtde(int totalVencidosQtde) {
		this.totalVencidosQtde = totalVencidosQtde;
	}


	public BigDecimal getTotalVencidosValor() {
		return totalVencidosValor;
	}
	
    public String getTotalVencidosValorFormatado() {
        return Formatador.formatarValorEmReais(totalVencidosValor);
    }

	public void setTotalVencidosValor(BigDecimal totalVencidosValor) {
		this.totalVencidosValor = totalVencidosValor;
	}


	public int getTotalVencendoDiaQtde() {
		return totalVencendoDiaQtde;
	}


	public void setTotalVencendoDiaQtde(int totalVencendoDiaQtde) {
		this.totalVencendoDiaQtde = totalVencendoDiaQtde;
	}


	public BigDecimal getTotalVencendoDiaValor() {
		return totalVencendoDiaValor;
	}

	public String getTotalVencendoDiaValorFormatado() {
		return Formatador.formatarValorEmReais(totalVencendoDiaValor);
	}
	
	public void setTotalVencendoDiaValor(BigDecimal totalVencendoDiaValor) {
		this.totalVencendoDiaValor = totalVencendoDiaValor;
	}


	public int getTotalVencerQtde() {
		return totalVencerQtde;
	}


	public void setTotalVencerQtde(int totalVencerQtde) {
		this.totalVencerQtde = totalVencerQtde;
	}


	public BigDecimal getTotalVencerValor() {
		return totalVencerValor;
	}

	public String getTotalVencerValorFormatado() {
		return Formatador.formatarValorEmReais(totalVencerValor);
	}
	
	public void setTotalVencerValor(BigDecimal totalVencerValor) {
		this.totalVencerValor = totalVencerValor;
	}


	public int getTotalLiquidadosDiaQtde() {
		return totalLiquidadosDiaQtde;
	}


	public void setTotalLiquidadosDiaQtde(int totalLiquidadosDiaQtde) {
		this.totalLiquidadosDiaQtde = totalLiquidadosDiaQtde;
	}


	public BigDecimal getTotalLiquidadosDiaValor() {
		return totalLiquidadosDiaValor;
	}

	public String getTotalLiquidadosDiaValorFormatado() {
		return Formatador.formatarValorEmReais(totalLiquidadosDiaValor);
	}

	public void setTotalLiquidadosDiaValor(BigDecimal totalLiquidadosDiaValor) {
		this.totalLiquidadosDiaValor = totalLiquidadosDiaValor;
	}

}
