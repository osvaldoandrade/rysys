package br.com.codecompany.rysys.iso8583.test.to;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class GuiaDebCredListaTO extends CadastroCedenteFiltroTO{

	private static final long serialVersionUID = 7876361291094172150L;
	
	private int numTotalPacotes;
	private int numPacote;
	private int pvVinculacao;
	private int numContasRateio;
	private int tpConclusao;
	private BigDecimal percPartCCredito;
	private BigDecimal percPartCDebito;
	private String contaCaucaoObrigatoria;
	private String rangeContasRateio;
	private String rangePercCredito;
	private String rangePercDebito;
	private String rangeValorRateio;
	private String contaCredito;
	private String contaDebito;
	private String contaCaucao;
	private String cadastrarContasRateio;
	private String nsuTransacao;
	private String numSeqUnico;
	
	private List<NumContasRateioListaTO> numContasRateioLista = new ArrayList<NumContasRateioListaTO>();  
	
	private List<GuiaDebCredTO> listarContasDebCredRateio = new ArrayList<GuiaDebCredTO>();

	public List<GuiaDebCredTO> getListarContasDebCredRateio() {
		return listarContasDebCredRateio;
	}

	public void setListarContasDebCredRateio(
			List<GuiaDebCredTO> consultarContasDebCredRateio) {
		this.listarContasDebCredRateio = consultarContasDebCredRateio;
	}

	public BigDecimal getPercPartCCredito() {
		return percPartCCredito;
	}

	public void setPercPartCCredito(BigDecimal percPartCCredito) {
		this.percPartCCredito = percPartCCredito;
	}

	public String getPercPartCCreditoFormatado(){
		if(this.percPartCCredito == null){
			return "";
		}else{	
			return Formatador.formatarValorPorcentagem(this.percPartCCredito);
		}
	}
	
	public String getPercPartCDebitoFormatado(){
		if(this.percPartCDebito == null){
			return "";
		}else{
			return Formatador.formatarValorPorcentagem(this.percPartCDebito);
		}
	}
	
	public BigDecimal getPercPartCDebito() {
		return percPartCDebito;
	}

	public void setPercPartCDebito(BigDecimal percPartCDebito) {
		this.percPartCDebito = percPartCDebito;
	}

	public String getContaCaucaoObrigatoria() {
		return contaCaucaoObrigatoria;
	}

	public void setContaCaucaoObrigatoria(String contaCaucaoObrigatoria) {
		this.contaCaucaoObrigatoria = contaCaucaoObrigatoria;
	}

	public int getNumContasRateio() {
		return numContasRateio;
	}

	public void setNumContasRateio(int numContasRateio) {
		this.numContasRateio = numContasRateio;
	}

	public List<NumContasRateioListaTO> getNumContasRateioLista() {
		return numContasRateioLista;
	}

	public void setNumContasRateioLista(
			List<NumContasRateioListaTO> numContasRateioList) {
		this.numContasRateioLista = numContasRateioList;
	}

	public String getRangeContasRateio() {
		return rangeContasRateio;
	}

	public void setRangeContasRateio(String rangeContasRateio) {
		this.rangeContasRateio = rangeContasRateio;
	}

	public String getRangePercCredito() {
		return rangePercCredito;
	}

	public void setRangePercCredito(String rangePercCredito) {
		this.rangePercCredito = rangePercCredito;
	}

	public String getRangePercDebito() {
		return rangePercDebito;
	}

	public void setRangePercDebito(String rangePercDebito) {
		this.rangePercDebito = rangePercDebito;
	}

	public String getRangeValorRateio() {
		return rangeValorRateio;
	}

	public void setRangeValorRateio(String rangeValorRateio) {
		this.rangeValorRateio = rangeValorRateio;
	}

	public String getContaCredito() {
		return contaCredito;
	}

	public void setContaCredito(String contaCredito) {
		this.contaCredito = contaCredito;
	}

	public String getContaDebito() {
		return contaDebito;
	}

	public void setContaDebito(String contaDebito) {
		this.contaDebito = contaDebito;
	}

	public String getContaCaucao() {
		return contaCaucao;
	}

	public void setContaCaucao(String contaCaucao) {
		this.contaCaucao = contaCaucao;
	}

	public String getCadastrarContasRateio() {
		return cadastrarContasRateio;
	}

	public void setCadastrarContasRateio(String cadastrarContasRateio) {
		this.cadastrarContasRateio = cadastrarContasRateio;
	}

	public String getNsuTransacao() {
		return nsuTransacao;
	}

	public void setNsuTransacao(String nsuTransacao) {
		this.nsuTransacao = nsuTransacao;
	}

	public String getNumSeqUnico() {
		return numSeqUnico;
	}

	public void setNumSeqUnico(String numSeqUnico) {
		this.numSeqUnico = numSeqUnico;
	}

	public int getNumTotalPacotes() {
		return numTotalPacotes;
	}

	public void setNumTotalPacotes(int numTotalPacotes) {
		this.numTotalPacotes = numTotalPacotes;
	}

	public int getNumPacote() {
		return numPacote;
	}

	public void setNumPacote(int numPacote) {
		this.numPacote = numPacote;
	}

	public int getPvVinculacao() {
		return pvVinculacao;
	}

	public void setPvVinculacao(int pvVinculacao) {
		this.pvVinculacao = pvVinculacao;
	}

	public int getTpConclusao() {
		return tpConclusao;
	}

	public void setTpConclusao(int tpConclusao) {
		this.tpConclusao = tpConclusao;
	}
}