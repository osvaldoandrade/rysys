package br.com.codecompany.rysys.iso8583.test.to;

import java.math.BigDecimal;


public class GuiaDebCredTO extends TransacaoTO{

	private static final long serialVersionUID = 1L;
	
	private int tpConta;
	private int tpPessoa;
	private String contaRateioUnidades;
	private String contaRateioOperacao;
	private String contaRateioConta;
	private String contaRateioDV;
	private String cpfCnpj;
	private String nomeTitular;
	private BigDecimal percRateioCred;
	private String percRateioCredFormatado;
	private BigDecimal percRateioDeb;
	private String percRateioDebFormatado;
	private BigDecimal valorRateio;
	private String valorRateioFormatado;
	private int index;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getTpConta() {
		return tpConta;
	}
	public void setTpConta(int tpConta) {
		this.tpConta = tpConta;
	}
	public String getContaRateioUnidades() {
		return contaRateioUnidades;
	}
	public void setContaRateioUnidades(String contaRateioUnidades) {
		this.contaRateioUnidades = contaRateioUnidades;
	}
	public String getContaRateioOperacao() {
		return contaRateioOperacao;
	}
	public void setContaRateioOperacao(String contaRateioOperacao) {
		this.contaRateioOperacao = contaRateioOperacao;
	}
	public String getContaRateioConta() {
		return contaRateioConta;
	}
	public void setContaRateioConta(String contaRateioConta) {
		this.contaRateioConta = contaRateioConta;
	}
	public String getContaRateioDV() {
		return contaRateioDV;
	}
	public void setContaRateioDV(String contaRateioDV) {
		this.contaRateioDV = contaRateioDV;
	}
	public BigDecimal getPercRateioCred() {
		return percRateioCred;
	}
	public void setPercRateioCred(BigDecimal percRateioCred) {
		this.percRateioCred = percRateioCred;
	}
	public BigDecimal getPercRateioDeb() {
		return percRateioDeb;
	}
	public void setPercRateioDeb(BigDecimal percRateioDeb) {
		this.percRateioDeb = percRateioDeb;
	}
	public BigDecimal getValorRateio() {
		return valorRateio;
	}
	public void setValorRateio(BigDecimal valorRateio) {
		this.valorRateio = valorRateio;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public String getPercRateioCredFormatado(){
		return Formatador.formatarValorPorcentagem(this.percRateioCred, true);
	}
	public String getPercRateioDebFormatado(){
		return Formatador.formatarValorPorcentagem(this.percRateioDeb, true);
	}
	public String getCpfCnpjFormatado(){
		return Formatador.formatarCpfCnpj(cpfCnpj);
	}
	public int getTpPessoa() {
		return tpPessoa;
	}
	public void setTpPessoa(int tpPessoa) {
		this.tpPessoa = tpPessoa;
	}
	public String getValorRateioFormatado() {
		return Formatador.formatarValorEmReais(this.valorRateio, true);
	}
	public void setValorRateioFormatado(String valorRateioFormatado) {
		try{
			setValorRateio(Formatador.desformatarValor(this.valorRateioFormatado));
		}catch(Exception e){
			throw new RuntimeException("Percentual de Juros Inválido",e);
		}
	}
	public void setPercRateioCredFormatado(String percRateioCredFormatado) {
		try{
			setPercRateioCred(Formatador.desformatarValor(percRateioCredFormatado));
		}catch(Exception e){
			throw new RuntimeException("Percentual de Juros Inválido",e);
		}
	}
	public void setPercRateioDebFormatado(String percRateioDebFormatado) {
		try{
			setPercRateioDeb(Formatador.desformatarValor(percRateioDebFormatado));
		}catch(Exception e){
			throw new RuntimeException("Percentual de Juros Inválido",e);
		}
	}
}