package br.com.codecompany.rysys.iso8583.test.to;

import java.math.BigDecimal;


public class ConsultarDebCredTO extends TransacaoTO{

	private static final long serialVersionUID = 1L;
	
	private int tpConta;
	private int contaRateioUnidades;
	private int contaRateioOperacao;
	private int contaRateioConta;
	private int contaRateioDV;
	private BigDecimal percRateioCred;
	private BigDecimal percRateioDeb;
	private BigDecimal valorRateio;
	
	public int getTpConta() {
		return tpConta;
	}
	public void setTpConta(int tpConta) {
		this.tpConta = tpConta;
	}
	public int getContaRateioUnidades() {
		return contaRateioUnidades;
	}
	public void setContaRateioUnidades(int contaRateioUnidades) {
		this.contaRateioUnidades = contaRateioUnidades;
	}
	public int getContaRateioOperacao() {
		return contaRateioOperacao;
	}
	public void setContaRateioOperacao(int contaRateioOperacao) {
		this.contaRateioOperacao = contaRateioOperacao;
	}
	public int getContaRateioConta() {
		return contaRateioConta;
	}
	public void setContaRateioConta(int contaRateioConta) {
		this.contaRateioConta = contaRateioConta;
	}
	public int getContaRateioDV() {
		return contaRateioDV;
	}
	public void setContaRateioDV(int contaRateioDV) {
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
	
}
