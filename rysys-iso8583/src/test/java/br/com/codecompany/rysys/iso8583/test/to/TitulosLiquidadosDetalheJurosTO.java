package br.com.codecompany.rysys.iso8583.test.to;

import java.math.BigDecimal;


public class TitulosLiquidadosDetalheJurosTO extends TitulosLiquidadosDetalheTO {
	
	private static final long serialVersionUID = 6229914993811113543L;
	
	private BigDecimal vlrJuros;
	private BigDecimal percentJurosMes;
	private BigDecimal vlrMulta;
	private BigDecimal percentMulta;
	private String dtMulta;
	private int prazoMulta;

	public String getDtMulta() {
        return dtMulta;
    }
    public void setDtMulta(String dtMulta) {
        this.dtMulta = dtMulta;
    }
    public BigDecimal getPercentJurosMes() {
		return percentJurosMes;
	}
    public String getPercentJurosMesFormatado() {
        return Formatador.formatarValorPorcentagem(percentJurosMes);
    }
	public void setPercentJurosMes(BigDecimal percentJurosMes) {
		this.percentJurosMes = percentJurosMes;
	}
	public BigDecimal getPercentMulta() {
		return percentMulta;
	}
    public String getPercentMultaFormatado() {
        return Formatador.formatarValorPorcentagem(percentMulta);
    }
	public void setPercentMulta(BigDecimal percentMulta) {
		this.percentMulta = percentMulta;
	}
	public int getPrazoMulta() {
		return prazoMulta;
	}
	public void setPrazoMulta(int prazoMulta) {
		this.prazoMulta = prazoMulta;
	}
	public BigDecimal getVlrJuros() {
		return vlrJuros;
	}
    public String getVlrJurosFormatado() {
        return Formatador.formatarValorEmReais(vlrJuros);
    }
	public void setVlrJuros(BigDecimal vlrJuros) {
		this.vlrJuros = vlrJuros;
	}
	public BigDecimal getVlrMulta() {
		return vlrMulta;
	}
    public String getVlrMultaFormatado() {
        return Formatador.formatarValorEmReais(vlrMulta);
    }
	public void setVlrMulta(BigDecimal vlrMulta) {
		this.vlrMulta = vlrMulta;
	}
}
