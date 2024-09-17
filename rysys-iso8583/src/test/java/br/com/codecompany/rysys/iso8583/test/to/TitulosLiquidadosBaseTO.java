package br.com.codecompany.rysys.iso8583.test.to;

import java.math.BigDecimal;


public class TitulosLiquidadosBaseTO extends PaginacaoTO {
	
	private static final long serialVersionUID = 6229914993811113543L;
	
	private int codCedente;
	private String nomeCedente;
	private int tpPessoa;
	private String cpfCnpj;
	private String nossoNumero;
	private BigDecimal vlrPagamento;
	private String meioLiquidacao;
	private int formaLiquidacao;
	private String sequencial;
	
	public int getCodCedente() {
		return codCedente;
	}
	
    public String getCodCedenteFormatado(){
        return Formatador.formatarNumeroCobol(this.codCedente, 6, 0);
    }

	public void setCodCedente(int codCedente) {
		this.codCedente = codCedente;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getNomeCedente() {
		return Formatador.toUpperCase(nomeCedente);
	}
	public void setNomeCedente(String nomeCedente) {
		this.nomeCedente = nomeCedente;
	}
	public int getTpPessoa() {
		return tpPessoa;
	}
	
    public String getCpfCnpjFormatado() {
	    if (this.tpPessoa == 1){
	        return Formatador.formatarCpf(this.cpfCnpj);
	    } else if (this.tpPessoa == 2){
	        return Formatador.formatarCnpj(this.cpfCnpj);
	    }
	    return "";
    }

    public String getDescricaoTpPessoa() {
        if (this.tpPessoa == 1){
            return "FÍSICA";
        }else if (this.tpPessoa == 2 ) {
            return "JURÍDICA";
        }
        return "";
    }

	public void setTpPessoa(int tpPessoa) {
		this.tpPessoa = tpPessoa;
	}
	
    public String getFormaLiquidacaoFormatado() {
        if( formaLiquidacao == 1 ) {
            return "DINHEIRO";
        }
        if( formaLiquidacao == 2 ) {
            return "CHEQUE";
        }
        if( formaLiquidacao == 3 ) {
            return "AMBOS";
        }
        return "";
    }
	public int getFormaLiquidacao() {
		return formaLiquidacao;
	}
	public void setFormaLiquidacao(int formaLiquidacao) {
		this.formaLiquidacao = formaLiquidacao;
	}
	public String getMeioLiquidacao() {
		return meioLiquidacao;
	}
	public void setMeioLiquidacao(String meioLiquidacao) {
		this.meioLiquidacao = meioLiquidacao;
	}
	public String getNossoNumero() {
		return nossoNumero;
	}
	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}
    public String getNossoNumeroFormatado(){
        return Formatador.formatarNumeroCobol(this.nossoNumero, 18, 0);
    }	
	public String getSequencial() {
		return sequencial;
	}
	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}
	public BigDecimal getVlrPagamento() {
		return vlrPagamento;
	}
    public String getVlrPagamentoFormatado(){
        return Formatador.formatarValorEmReais(this.vlrPagamento);
    }
	public void setVlrPagamento(BigDecimal vlrPagamento) {
		this.vlrPagamento = vlrPagamento;
	}
}
