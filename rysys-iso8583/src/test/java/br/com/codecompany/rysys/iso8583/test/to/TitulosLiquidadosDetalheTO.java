package br.com.codecompany.rysys.iso8583.test.to;

import java.math.BigDecimal;


public class TitulosLiquidadosDetalheTO extends TitulosLiquidadosBaseTO {
	
	private static final long serialVersionUID = 6229914993811113543L;
	
	private BigDecimal vlrOriginalTitulo;
	private String situacaoTitulo;
	private String dtSituacao;
	private String dtVencimentoTitulo;
	private int modalidadeTitulo;
	private String dtCredito;
	private String descMoeda;
	private int codUnidadeRecebedora;
	private int codUnidadeCobradora;
	private String especieTitulo;
	private String descAceite;
	private int qtdMoeda;
	private BigDecimal vlrAbatimento;
	
	public int getCodUnidadeCobradora() {
		return codUnidadeCobradora;
	}
	public void setCodUnidadeCobradora(int codUnidadeCobradora) {
		this.codUnidadeCobradora = codUnidadeCobradora;
	}
	public int getCodUnidadeRecebedora() {
		return codUnidadeRecebedora;
	}
	public void setCodUnidadeRecebedora(int codUnidadeRecebedora) {
		this.codUnidadeRecebedora = codUnidadeRecebedora;
	}
	public String getDescAceite() {
		return descAceite;
	}
	public void setDescAceite(String descAceite) {
		this.descAceite = descAceite;
	}
	public String getDescMoeda() {
		return descMoeda;
	}
	public void setDescMoeda(String descMoeda) {
		this.descMoeda = descMoeda;
	}
	public String getDtCredito() {
		return dtCredito;
	}
	public void setDtCredito(String dtCredito) {
		this.dtCredito = dtCredito;
	}
	public String getDtSituacao() {
		return dtSituacao;
	}
	public void setDtSituacao(String dtSituacao) {
		this.dtSituacao = dtSituacao;
	}
	public String getDtVencimentoTitulo() {
		return dtVencimentoTitulo;
	}
	public void setDtVencimentoTitulo(String dtVencimentoTitulo) {
		this.dtVencimentoTitulo = dtVencimentoTitulo;
	}
	public String getEspecieTitulo() {
		return especieTitulo;
	}
	public void setEspecieTitulo(String especieTitulo) {
		this.especieTitulo = especieTitulo;
	}
	public int getModalidadeTitulo() {
		return modalidadeTitulo;
	}
	public void setModalidadeTitulo(int modalidadeTitulo) {
		this.modalidadeTitulo = modalidadeTitulo;
	}
	public int getQtdMoeda() {
		return qtdMoeda;
	}
	public void setQtdMoeda(int qtdMoeda) {
		this.qtdMoeda = qtdMoeda;
	}
	public String getSituacaoTitulo() {
		return situacaoTitulo;
	}
	public void setSituacaoTitulo(String situacaoTitulo) {
		this.situacaoTitulo = situacaoTitulo;
	}
	public BigDecimal getVlrAbatimento() {
		return vlrAbatimento;
	}
    public String getVlrAbatimentoFormatado() {
        return Formatador.formatarValorEmReais(vlrAbatimento);
    }
	public void setVlrAbatimento(BigDecimal vlrAbatimento) {
		this.vlrAbatimento = vlrAbatimento;
	}
	public BigDecimal getVlrOriginalTitulo() {
		return vlrOriginalTitulo;
	}
    public String getVlrOriginalTituloFormatado() {
        return Formatador.formatarValorEmReais(vlrOriginalTitulo);
    }
	public void setVlrOriginalTitulo(BigDecimal vlrOriginalTitulo) {
		this.vlrOriginalTitulo = vlrOriginalTitulo;
	}
}
