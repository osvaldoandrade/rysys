package br.com.codecompany.rysys.api.test.to;

public class PaginacaoTO extends TransacaoTO {

	private static final long serialVersionUID = 1L;

	private int qtdPaginas;
	private String nomeTabelaTemp;
	private int pagAtual;

	public int getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	public String getNomeTabelaTemp() {
		return nomeTabelaTemp;
	}

	public void setNomeTabelaTemp(String nomeTabelaTemp) {
		this.nomeTabelaTemp = nomeTabelaTemp;
	}

	public int getPagAtual() {
		return pagAtual;
	}

	public void setPagAtual(int pagAtual) {
		this.pagAtual = pagAtual;
	}

}
