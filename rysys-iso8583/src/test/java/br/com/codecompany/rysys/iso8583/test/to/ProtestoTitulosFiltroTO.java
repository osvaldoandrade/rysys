package br.com.codecompany.rysys.iso8583.test.to;


public class ProtestoTitulosFiltroTO extends PaginacaoTO {

	private static final long serialVersionUID = 6811499636006303231L;
	
	private int tpConsulta;
	private String pvCobrador;
	private String diasProtesto;
	private String usuario;
	private String tpSelecao;
	private UsuarioTO usuarioTO;
		
	public int getTpConsulta() {
		return tpConsulta;
	}
	public void setTpConsulta(int tpConsulta) {
		this.tpConsulta = tpConsulta;
	}
	public String getPvCobrador() {
		return pvCobrador;
	}
	public void setPvCobrador(String pvCobrador) {
		this.pvCobrador = pvCobrador;
	}
	public String getDiasProtesto() {
		return diasProtesto;
	}
	public void setDiasProtesto(String diasProtesto) {
		this.diasProtesto = diasProtesto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTpSelecao() {
		return tpSelecao;
	}
	public void setTpSelecao(String tpSelecao) {
		this.tpSelecao = tpSelecao;
	}
	
	public String getRelatorio (){
		
		if (this.tpConsulta == 1){
			return Formatador.toUpperCase("Títulos a serem Enviados ao Cartório");
		} else if (this.tpConsulta == 2 ){
			return Formatador.toUpperCase("Títulos Enviados ao Cartório");
		} else if (this.tpConsulta == 3 ){
			return Formatador.toUpperCase("Títulos com Envio Suspenso");
		} else if (this.tpConsulta == 4 ){
			return Formatador.toUpperCase("Títulos Enviados com mais de " + this.diasProtesto + " dias");
		}
		return "";
	}
	
	public String getPvCobradorFormatado(){
		return Formatador.formatarNumeroCobol(String.valueOf(pvCobrador), 4, 0);
	}
	public UsuarioTO getUsuarioTO() {
		return usuarioTO;
	}
	public void setUsuarioTO(UsuarioTO usuarioTO) {
		this.usuarioTO = usuarioTO;
	}
	
}
