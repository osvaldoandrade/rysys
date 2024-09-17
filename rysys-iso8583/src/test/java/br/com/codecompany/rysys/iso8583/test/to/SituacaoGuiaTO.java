package br.com.codecompany.rysys.iso8583.test.to;

import java.io.Serializable;


public class SituacaoGuiaTO implements Serializable{
	
	private static final long serialVersionUID = 5842688903569665284L;
	
	public static final String DESCRICAO_SITUACAO_GUIA_NAO_CADASTRADA = "Não Cadastrado";
	public static final String DESCRICAO_SITUACAO_GUIA_CADASTRADA = "Cadastrado";
	public static final String DESCRICAO_SITUACAO_GUIA_EM_CADASTRAMENTO = "Em Cadastramento";
	public static final String DESCRICAO_SITUACAO_GUIA_NAO_PERMITIDA = "Não Permitido";
	
	public static final String SITUACAO_GUIA_NAO_CADASTRADA = "NC";
	public static final String SITUACAO_GUIA_NAO_PERMITIDA = "NP";
	public static final String SITUACAO_GUIA_CADASTRADA = "C";
	public static final String SITUACAO_GUIA_EM_CADASTRAMENTO = "E";
	
	private String situacaoGuia;
	private int guia;
	
	public String getDescricaoSituacao() {
		
		if (SITUACAO_GUIA_CADASTRADA.equalsIgnoreCase(situacaoGuia)){
			return DESCRICAO_SITUACAO_GUIA_CADASTRADA;
		}
		if (SITUACAO_GUIA_EM_CADASTRAMENTO.equalsIgnoreCase(situacaoGuia)){
			return DESCRICAO_SITUACAO_GUIA_EM_CADASTRAMENTO;
		}
		if (SITUACAO_GUIA_NAO_CADASTRADA.equalsIgnoreCase(situacaoGuia)){
			return DESCRICAO_SITUACAO_GUIA_NAO_CADASTRADA;
		}
		if (SITUACAO_GUIA_NAO_PERMITIDA.equalsIgnoreCase(situacaoGuia)){
			return DESCRICAO_SITUACAO_GUIA_NAO_PERMITIDA;
		}
		
		throw new RuntimeException("Situacao da 'Guia' = " + situacaoGuia +" inválida!");
	}
	public int getGuia() {
		return guia;
	}
	public void setGuia(int guia) {
		this.guia = guia;
	}
	public String getNomeGuia() {
		return GuiaCadastroCedente.getGuia(guia).getDescricaoGuia();
	}
	public String getNomeConfirmacaoOK() {
		return GuiaCadastroCedente.getGuia(guia).getNomeConfirmacaoOK();
	}
	public String getSituacaoGuia() {
		return situacaoGuia;
	}
	public void setSituacaoGuia(String situacaoGuia) {
		this.situacaoGuia = situacaoGuia;
	}
	
	public boolean isGuiaCedenteEletronico(){
		if (guia == GuiaCadastroCedente.GUIA_CEDENTE_ELETRONICO.getNumGuia()){
			return true;
		}
		return false;			
	}
}
