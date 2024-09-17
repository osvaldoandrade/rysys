package br.com.codecompany.rysys.iso8583.test.to;


public class TitulosAlteradosTO extends PaginacaoTO {

	private static final long serialVersionUID = -492990711843184493L;
	
	private String comando;
	private String dtAlteracao;
	private long nossoNumero;
	private int codCedente;
	private String nomeCedente;
	
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	public String getDtAlteracao() {
		return dtAlteracao;
	}
	public void setDtAlteracao(String dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}
	public long getNossoNumero() {
		return nossoNumero;
	}
	public void setNossoNumero(long nossoNumero) {
		this.nossoNumero = nossoNumero;
	}
	public String getNossoNumeroFormatado(){
		return Formatador.formatarNumeroCobol(this.nossoNumero, 17, 0);
	}		
	public int getCodCedente() {
		return codCedente;
	}
	public void setCodCedente(int codCedente) {
		this.codCedente = codCedente;
	}
	public String getCodCedenteFormatado(){
		return Formatador.formatarNumeroCobol(this.codCedente, 6, 0);
	}	
	public String getNomeCedente() {
		return Formatador.toUpperCase(nomeCedente);
	}
	public void setNomeCedente(String nomeCedente) {
		this.nomeCedente = nomeCedente;
	}
	
}
