package br.com.codecompany.rysys.iso8583.test.to;

import java.math.BigDecimal;


public class ConsultaCateiraCobrancaTO extends TransacaoTO{
	
	private static final long serialVersionUID = 2432327346219471487L;
	
	private String especieTitulo;
	private int vencidosQtde;
	private BigDecimal vencidosValor;
	private int vencendoDiaQtde;
	private BigDecimal vencendoDiaValor;
	private int vencerQtde;
	private BigDecimal vencerValor;
	private int liquidadosDiaQtde;
	private BigDecimal liquidadosDiaValor;
	private String registrada;
	
	public String getEspecieTitulo() {
		return especieTitulo;
	}
	public void setEspecieTitulo(String especieTitulo) {
		this.especieTitulo = especieTitulo;
	}
	public int getVencidosQtde() {
		return vencidosQtde;
	}
	public void setVencidosQtde(int vencidosQtde) {
		this.vencidosQtde = vencidosQtde;
	}
	public BigDecimal getVencidosValor() {
		return vencidosValor;
	}
	public String getVencidosValorFormatado() {
		return Formatador.formatarValorEmReais(vencidosValor);
	}	
	public void setVencidosValor(BigDecimal vencidosValor) {
		this.vencidosValor = vencidosValor;
	}
	public int getVencendoDiaQtde() {
		return vencendoDiaQtde;
	}
	public void setVencendoDiaQtde(int vencendoDiaQtde) {
		this.vencendoDiaQtde = vencendoDiaQtde;
	}
	public BigDecimal getVencendoDiaValor() {
		return vencendoDiaValor;
	}
	public String getVencendoDiaValorFormatado() {
		return Formatador.formatarValorEmReais(vencendoDiaValor);
	}	
	public void setVencendoDiaValor(BigDecimal vencendoDiaValor) {
		this.vencendoDiaValor = vencendoDiaValor;
	}
	public int getVencerQtde() {
		return vencerQtde;
	}
	public void setVencerQtde(int vencerQtde) {
		this.vencerQtde = vencerQtde;
	}
	public BigDecimal getVencerValor() {
		return vencerValor;
	}
	public String getVencerValorFormatado() {
		return Formatador.formatarValorEmReais(vencerValor);
	}	
	public void setVencerValor(BigDecimal vencerValor) {
		this.vencerValor = vencerValor;
	}
	public int getLiquidadosDiaQtde() {
		return liquidadosDiaQtde;
	}
	public void setLiquidadosDiaQtde(int liquidadosDiaQtde) {
		this.liquidadosDiaQtde = liquidadosDiaQtde;
	}
	public BigDecimal getLiquidadosDiaValor() {
		return liquidadosDiaValor;
	}
	public String getLiquidadosDiaValorFormatado() {
		return Formatador.formatarValorEmReais(liquidadosDiaValor);
	}	
	public void setLiquidadosDiaValor(BigDecimal liquidadosDiaValor) {
		this.liquidadosDiaValor = liquidadosDiaValor;
	}
	public String getRegistrada() {
		return registrada;
	}
	public void setRegistrada(String registrada) {
		this.registrada = registrada;
	}	


}
