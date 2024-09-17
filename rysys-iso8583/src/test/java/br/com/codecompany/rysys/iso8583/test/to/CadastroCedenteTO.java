package br.com.codecompany.rysys.iso8583.test.to;

import java.util.ArrayList;
import java.util.List;


public class CadastroCedenteTO extends TransacaoTO{
	
	private static final long serialVersionUID = 2432327346219471487L;
	
	public static final String TIPO_CEDENTE_ELETRONICO_PERMITIDO = "S";
	public static final String TIPO_CEDENTE_ELETRONICO_NAO_PERMITIDO = "N";
	
	public static final String SITUACAO_GUIA_CEDENTE_ELETRONICO_CADASTRADO = "S";
	public static final String SITUACAO_GUIA_CEDENTE_ELETRONICO_NAO_CADASTRADO = "N";
	
	private String tpCedente;
	private String situacaoGuiaCedenteEletronico;
	private int ultimaGuiaCadastrada;
	private int modalidadeTitulo;
	private String codUnidadeSR;
	private String codUnidadePV;
	private String cargoUsuario;
	private String situacaoCedente;
	private String excepcionacaoPendente;
	private boolean isSemControleGuiaCadastrada = false;
	public static final String SITUACAO_CEDENTE_ATIVO = "A";
	public static final String SITUACAO_CEDENTE_INATIVO = "I";
	public static final String EXCEP_NAO_PENDENTE = "0";
	public static final String EXCEP_EM_ABERTO = "1";
	public static final String EXCEP_LIBERADO = "2";
	
	
	private List<SituacaoGuiaTO> listaSituacaoGuia = new ArrayList<SituacaoGuiaTO>();
	
	public String getCargoUsuario() {
		return cargoUsuario;
	}
	public void setCargoUsuario(String cargoUsuario) {
		this.cargoUsuario = cargoUsuario;
	}
	public String getCodUnidadePV() {
		return codUnidadePV;
	}
	public void setCodUnidadePV(String codUnidadePV) {
		this.codUnidadePV = codUnidadePV;
	}
	public String getCodUnidadeSR() {
		return codUnidadeSR;
	}
	public void setCodUnidadeSR(String codUnidadeSR) {
		this.codUnidadeSR = codUnidadeSR;
	}
	public int getUltimaGuiaCadastrada() {
		return ultimaGuiaCadastrada;
	}
	public void setUltimaGuiaCadastrada(int ultimaGuiaCadastrada) {
		this.ultimaGuiaCadastrada = ultimaGuiaCadastrada;
	}
	public int getModalidadeTitulo() {
		return modalidadeTitulo;
	}
	public void setModalidadeTitulo(int modalidadeTitulo) {
		this.modalidadeTitulo = modalidadeTitulo;
	}
	public String getSituacaoGuiaCedenteEletronico() {
		return situacaoGuiaCedenteEletronico;
	}
	public void setSituacaoGuiaCedenteEletronico(String situacaoGuiaCedenteEletronico) {
		this.situacaoGuiaCedenteEletronico = situacaoGuiaCedenteEletronico;
	}
	public String getTpCedente() {
		return tpCedente;
	}
	public void setTpCedente(String tpCedente) {
		this.tpCedente = tpCedente;
	}
	public List<SituacaoGuiaTO> getListaSituacaoGuia() {
		return listaSituacaoGuia;
	}
	public void setListaSituacaoGuia(List<SituacaoGuiaTO> listaSituacaoGuia) {
		this.listaSituacaoGuia = listaSituacaoGuia;
	}
	
	public boolean isCedenteEletronicoNaoPermitido(){
		if (CadastroCedenteTO.TIPO_CEDENTE_ELETRONICO_NAO_PERMITIDO.equalsIgnoreCase(this.tpCedente)){
			return true;
		}
		return false;
	}
	
	public boolean isCedenteEltronicoCadastrado(){
		if (CadastroCedenteTO.SITUACAO_GUIA_CEDENTE_ELETRONICO_CADASTRADO.equalsIgnoreCase(this.situacaoGuiaCedenteEletronico)){
			return true;
		}
		return false;
	}
	
	public boolean isCedenteEletronicoPermitido(){
		if (CadastroCedenteTO.TIPO_CEDENTE_ELETRONICO_PERMITIDO.equalsIgnoreCase(this.tpCedente)){
			return true;
		}
		return false;
	}
	public String getExcepcionacaoPendente() {
		return excepcionacaoPendente;
	}
	public void setExcepcionacaoPendente(String excepcionacaoPendente) {
		this.excepcionacaoPendente = excepcionacaoPendente;
	}
	public String getSituacaoCedente() {
		return situacaoCedente;
	}
	public void setSituacaoCedente(String situacaoCedente) {
		this.situacaoCedente = situacaoCedente;
	}
	public boolean isSemControleGuiaCadastrada() {
		return isSemControleGuiaCadastrada;
	}
	public void setSemControleGuiaCadastrada(boolean isSemControleGuiaCadastrada) {
		this.isSemControleGuiaCadastrada = isSemControleGuiaCadastrada;
	}
}
