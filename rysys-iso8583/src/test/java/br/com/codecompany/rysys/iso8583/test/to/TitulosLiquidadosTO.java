package br.com.codecompany.rysys.iso8583.test.to;

public class TitulosLiquidadosTO extends TitulosLiquidadosDetalheDescontoTO {
	
	private static final long serialVersionUID = 6229914993811113543L;
	
	private String dtEntrada;
	private String dtEmissao;
	private String dtProtesto;
	private int prazoProtesto;
	private int numLote;
	private String numDocumento;
	private String nomeSacado;
	private String descCarteira;

	public String getDescCarteira() {
		return descCarteira;
	}
	public void setDescCarteira(String descCarteira) {
		this.descCarteira = descCarteira;
	}
	public String getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(String dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public String getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	public String getDtProtesto() {
		return dtProtesto;
	}
	public void setDtProtesto(String dtProtesto) {
		this.dtProtesto = dtProtesto;
	}
	public String getNomeSacado() {
		return nomeSacado;
	}
	public void setNomeSacado(String nomeSacado) {
		this.nomeSacado = nomeSacado;
	}
	public String getNumDocumento() {
		return numDocumento;
	}
	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}
	public int getNumLote() {
		return numLote;
	}
	public void setNumLote(int numLote) {
		this.numLote = numLote;
	}
	public int getPrazoProtesto() {
		return prazoProtesto;
	}
	public void setPrazoProtesto(int prazoProtesto) {
		this.prazoProtesto = prazoProtesto;
	}
}
