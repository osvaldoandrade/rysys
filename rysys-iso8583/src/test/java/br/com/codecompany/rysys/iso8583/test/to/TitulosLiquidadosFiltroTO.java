package br.com.codecompany.rysys.iso8583.test.to;


public class TitulosLiquidadosFiltroTO extends PaginacaoTO {

	private static final long serialVersionUID = -4381505263293939863L;
	
	private String tpSelecao;
	
	private int tpConsulta;
	private String codUnidadeVinculacao;
	private String dtPagamento;
	private String codCedente;
	private String nossoNumero;
	private String dtSolicitacao;
	private String sequencial;
	private UsuarioTO usuarioTO;
	private int consultaEscolhida;
	
	public String getTpSelecao() {
        return tpSelecao;
    }
    public void setTpSelecao(String tipoSelecao) {
        this.tpSelecao = tipoSelecao;
    }
    
    public String getCodCedenteFormatado() {
		return Formatador.formatarNumeroCobol(codCedente, 6, 0);
	}
    public String getCodCedente() {
		return codCedente;
	}
	public void setCodCedente(String codCedente) {
		this.codCedente = codCedente;
	}
	public String getCodUnidadeVinculacao() {
		return codUnidadeVinculacao;
	}
	public String getCodUnidadeVinculacaoFormatado() {
		return Formatador.formatarNumeroCobol(codUnidadeVinculacao, 4, 0);
	}
	public void setCodUnidadeVinculacao(String codUnidadeVinculacao) {
		this.codUnidadeVinculacao = codUnidadeVinculacao;
	}
	public String getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(String dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	public int getTpConsulta() {
		return tpConsulta;
	}
	public void setTpConsulta(int tpConsulta) {
		this.tpConsulta = tpConsulta;
	}
	public String getDtSolicitacao() {
		return dtSolicitacao;
	}
	public void setDtSolicitacao(String dtSolicitacao) {
		this.dtSolicitacao = dtSolicitacao;
	}
	public String getNossoNumero() {
		return nossoNumero;
	}
	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}
	public String getSequencial() {
		return sequencial;
	}
	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}
	public UsuarioTO getUsuarioTO() {
		return usuarioTO;
	}
	public void setUsuarioTO(UsuarioTO usuarioTO) {
		this.usuarioTO = usuarioTO;
	}
	public int getConsultaEscolhida() {
		return consultaEscolhida;
	}
	public void setConsultaEscolhida(int consultaEscolhida) {
		this.consultaEscolhida = consultaEscolhida;
	}
}
