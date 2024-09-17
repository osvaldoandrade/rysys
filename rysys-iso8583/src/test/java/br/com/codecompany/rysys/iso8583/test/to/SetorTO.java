package br.com.codecompany.rysys.iso8583.test.to;


public class SetorTO extends TransacaoTO{

	private static final long serialVersionUID = 7905269859695717486L;
	
	private int codSetor;
	private String descricaoSetor;
	
	public String getDescricaoSetor() {
		return descricaoSetor;
	}
	public void setDescricaoSetor(String descricaoTpJuros) {
		this.descricaoSetor = descricaoTpJuros;
	}
	public int getCodSetor() {
		return codSetor;
	}
	public void setCodSetor(int codSetor) {
		this.codSetor = codSetor;
	}	
}
