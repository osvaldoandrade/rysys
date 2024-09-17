package br.com.codecompany.rysys.iso8583.test.to;

import java.math.BigDecimal;


public class ProtestoTitulosTO extends PaginacaoTO{

	private static final long serialVersionUID = -2486997179999410372L;

	private long nossoNumero;
    private String codCedente;
    private String nomeDevedor;
    private int tpPessoa;
    private BigDecimal cpfCnpj;
    private String seuNumero;
    private String dtGenerica;
    private String modalidade;
    private String espTitulo;
    private BigDecimal vlrTitulo;
    private int numCartorio;
    private long protocolo;
    private String dtProtocolo;
    private String dtEnvioProtesto;
    
	public long getNossoNumero() {
		return nossoNumero;
	}
	public void setNossoNumero(long nossoNumero) {
		this.nossoNumero = nossoNumero;
	}
	public String getCodCedente() {
		return codCedente;
	}
	public void setCodCedente(String codCedente) {
		this.codCedente = codCedente;
	}
	public String getNomeDevedor() {
		return nomeDevedor;
	}
	public void setNomeDevedor(String nomeDevedor) {
		this.nomeDevedor = nomeDevedor;
	}
	public int getTpPessoa() {
		return tpPessoa;
	}
	public void setTpPessoa(int tpPessoa) {
		this.tpPessoa = tpPessoa;
	}
	public BigDecimal getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(BigDecimal cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getSeuNumero() {
		return seuNumero;
	}
	public void setSeuNumero(String seuNumero) {
		this.seuNumero = seuNumero;
	}
	public String getDtGenerica() {
		return dtGenerica;
	}
	public void setDtGenerica(String dtGenerica) {
		this.dtGenerica = dtGenerica;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public String getEspTitulo() {
		return espTitulo;
	}
	public void setEspTitulo(String espTitulo) {
		this.espTitulo = espTitulo;
	}
	public BigDecimal getVlrTitulo() {
		return vlrTitulo;
	}
	public void setVlrTitulo(BigDecimal vlrTitulo) {
		this.vlrTitulo = vlrTitulo;
	}
	public int getNumCartorio() {
		return numCartorio;
	}
	public void setNumCartorio(int numCartorio) {
		this.numCartorio = numCartorio;
	}
	public long getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(long protocolo) {
		this.protocolo = protocolo;
	}
	public String getDtProtocolo() {
		return dtProtocolo;
	}
	public void setDtProtocolo(String dtProtocolo) {
		this.dtProtocolo = dtProtocolo;
	}
	public String getDtEnvioProtesto() {
		return dtEnvioProtesto;
	}
	public void setDtEnvioProtesto(String dtEnvioProtesto) {
		this.dtEnvioProtesto = dtEnvioProtesto;
	}
	public String getCodCedenteFormatado(){
		return Formatador.formatarNumeroCobol(String.valueOf(codCedente), 6, 0);
	}
	public String getCpfCnpjFormatado(){
		return Formatador.formatarCpfCnpj(String.valueOf(this.cpfCnpj));
	}
	public String getVlrTituloFormatado(){
		return Formatador.formatarValorEmReais(this.vlrTitulo);
	}
	public String getNossoNumeroFormatado(){
		return Formatador.formatarNumeroCobol(String.valueOf(nossoNumero), 17, 0);
	}
	public String getProtocoloFormatado(){
		return Formatador.formatarNumeroCobol(String.valueOf(protocolo), 10, 0);
	}
	public String getNumCartorioFormatado(){
		return Formatador.formatarNumeroCobol(String.valueOf(numCartorio), 2, 0);
	}
    
}
