package br.com.codecompany.rysys.iso8583.test.to;

import java.io.Serializable;

import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.TextField;

public class TransacaoTO implements Serializable {
    
	private static final long serialVersionUID = -2159969233732375972L;
		
	@IntegerField(index=1, length=1)
	private static final String ATENDIMENTO = "0";
	
	@IntegerField(index=2, length=3)
	private static final String VERSAO = "001";
	
	@IntegerField(index=3, length=4)
	private static final String COD_RESP = "0000";
	
	@TextField(index=4, length=18)
	private static final String  CONTROLE_CEF = "                  ";
	
	@IntegerField(index=5, length=10)
	private static final String  CONTROLE_CEF_2 = "0000000000";
	
	private String usuario;
	
	//atributos usado somente para as paginas que utilizam o recurso da paginacao
	private String eventoPaginacao;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getAtendimento() {
		return ATENDIMENTO;
	}
	public String getCodResp() {
		return COD_RESP;
	}
	public String getControleCEF() {
		return CONTROLE_CEF;
	}
	public String getControleCEF2() {
		return CONTROLE_CEF_2;
	}
	public String getVersao() {
		return VERSAO;
	}
	public String getEventoPaginacao() {
		return eventoPaginacao;
	}
	public void setEventoPaginacao(String evento) {
		this.eventoPaginacao = evento;
	}
}
