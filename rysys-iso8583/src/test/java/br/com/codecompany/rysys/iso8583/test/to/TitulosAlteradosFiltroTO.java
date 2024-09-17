package br.com.codecompany.rysys.iso8583.test.to;


public class TitulosAlteradosFiltroTO extends PaginacaoTO {

	private static final long serialVersionUID = 4311349750017300993L;

	private int codUnidadePv;
	private String dtComandada;
	private UsuarioTO usuarioTO;
	
	public int getCodUnidadePv() {
		return codUnidadePv;
	}
	public void setCodUnidadePv(int codUnidadePv) {
		this.codUnidadePv = codUnidadePv;
	}
	public String getCodUnidadePvFormatado(){
		return Formatador.formatarNumeroCobol(this.codUnidadePv, 4, 0);
	}	
	public String getDtComandada() {
		return dtComandada;
	}
	public void setDtComandada(String dtComandada) {
		this.dtComandada = dtComandada;
	}
	public UsuarioTO getUsuarioTO() {
		return usuarioTO;
	}
	public void setUsuarioTO(UsuarioTO usuarioTO) {
		this.usuarioTO = usuarioTO;
	}
	
}
