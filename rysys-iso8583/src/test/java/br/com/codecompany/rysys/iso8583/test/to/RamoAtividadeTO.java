package br.com.codecompany.rysys.iso8583.test.to;


public class RamoAtividadeTO extends TransacaoTO{

	private static final long serialVersionUID = 193796615539791089L;
	private int codNatureza;
	private String codRamo;
	private String nomeRamo;
	
	public int getCodNatureza() {
		return codNatureza;
	}
	public void setCodNatureza(int codNatureza) {
		this.codNatureza = codNatureza;
	}
	public String getCodRamo() {
		return codRamo;
	}
	public void setCodRamo(String codRamo) {
		this.codRamo = codRamo;
	}
	public String getNomeRamo() {
		return nomeRamo;
	}
	public void setNomeRamo(String nomeRamo) {
		this.nomeRamo = nomeRamo;
	}
	
}
