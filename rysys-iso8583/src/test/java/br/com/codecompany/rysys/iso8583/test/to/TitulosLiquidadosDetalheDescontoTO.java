package br.com.codecompany.rysys.iso8583.test.to;

import java.math.BigDecimal;


public class TitulosLiquidadosDetalheDescontoTO extends TitulosLiquidadosDetalheJurosTO {
	
	private static final long serialVersionUID = 6229914993811113543L;
	
	private BigDecimal vlrDesconto1;
	private BigDecimal percentDesconto1;
	private String dtDesconto1;
	private int prazoDesconto1;
	private BigDecimal vlrDesconto2;
	private BigDecimal percentDesconto2;
	private String dtDesconto2;
	private int prazoDesconto2;
	private BigDecimal vlrDesconto3;
	private BigDecimal percentDesconto3;
	private String dtDesconto3;
	private int prazoDesconto3;

	public String getDtDesconto1() {
		return dtDesconto1;
	}
	public void setDtDesconto1(String dtDesconto1) {
		this.dtDesconto1 = dtDesconto1;
	}
	public String getDtDesconto2() {
		return dtDesconto2;
	}
	public void setDtDesconto2(String dtDesconto2) {
		this.dtDesconto2 = dtDesconto2;
	}
	public String getDtDesconto3() {
		return dtDesconto3;
	}
	public void setDtDesconto3(String dtDesconto3) {
		this.dtDesconto3 = dtDesconto3;
	}
	public BigDecimal getPercentDesconto1() {
		return percentDesconto1;
	}
    public String getPercentDesconto1Formatado() {
        return Formatador.formatarValorPorcentagem(percentDesconto1);
    }
	public void setPercentDesconto1(BigDecimal percentDesconto1) {
		this.percentDesconto1 = percentDesconto1;
	}
	public BigDecimal getPercentDesconto2() {
		return percentDesconto2;
	}
    public String getPercentDesconto2Formatado() {
        return Formatador.formatarValorPorcentagem(percentDesconto2);
    }
	public void setPercentDesconto2(BigDecimal percentDesconto2) {
		this.percentDesconto2 = percentDesconto2;
	}
	public BigDecimal getPercentDesconto3() {
		return percentDesconto3;
	}
    public String getPercentDesconto3Formatado() {
        return Formatador.formatarValorPorcentagem(percentDesconto3);
    }
	public void setPercentDesconto3(BigDecimal percentDesconto3) {
		this.percentDesconto3 = percentDesconto3;
	}
	public int getPrazoDesconto1() {
		return prazoDesconto1;
	}
	public void setPrazoDesconto1(int prazoDesconto1) {
		this.prazoDesconto1 = prazoDesconto1;
	}
	public int getPrazoDesconto2() {
		return prazoDesconto2;
	}
	public void setPrazoDesconto2(int prazoDesconto2) {
		this.prazoDesconto2 = prazoDesconto2;
	}
	public int getPrazoDesconto3() {
		return prazoDesconto3;
	}
	public void setPrazoDesconto3(int prazoDesconto3) {
		this.prazoDesconto3 = prazoDesconto3;
	}
	public BigDecimal getVlrDesconto1() {
		return vlrDesconto1;
	}
    public String getVlrDesconto1Formatado() {
        return Formatador.formatarValorEmReais(vlrDesconto1);
    }
	public void setVlrDesconto1(BigDecimal vlrDesconto1) {
		this.vlrDesconto1 = vlrDesconto1;
	}
	public BigDecimal getVlrDesconto2() {
		return vlrDesconto2;
	}
    public String getVlrDesconto2Formatado() {
        return Formatador.formatarValorEmReais(vlrDesconto2);
    }
	public void setVlrDesconto2(BigDecimal vlrDesconto2) {
		this.vlrDesconto2 = vlrDesconto2;
	}
	public BigDecimal getVlrDesconto3() {
		return vlrDesconto3;
	}
    public String getVlrDesconto3Formatado() {
        return Formatador.formatarValorEmReais(vlrDesconto3);
    }
	public void setVlrDesconto3(BigDecimal vlrDesconto3) {
		this.vlrDesconto3 = vlrDesconto3;
	}
}
