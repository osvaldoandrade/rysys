package br.com.codecompany.rysys.iso8583.test.to;

import java.io.Serializable;

public class UsuarioTO implements Serializable{
	
    private static final long serialVersionUID = 2718164790603006518L;
    
    private String codUsuario;
    private Integer codUnidadeLotacao;
	private String nomeUsuario;
	private String grupoVinculacao;
	private String descAreaUnidade;
	private String codFuncao;
	private String cpf;
    
    public Integer getCodUnidadeLotacao() {
        return codUnidadeLotacao;
    }
    public void setCodUnidadeLotacao(Integer codUnidadeLotacao) {
        this.codUnidadeLotacao = codUnidadeLotacao;
    }
    public String getCodUsuario() {
        return codUsuario;
    }
    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }
	public String getCodFuncao() {
		return codFuncao;
	}
	public void setCodFuncao(String codFuncao) {
		this.codFuncao = codFuncao;
	}
    public String getDescAreaUnidade() {
        return descAreaUnidade;
    }
    public void setDescAreaUnidade(String descAreaUnidade) {
        this.descAreaUnidade = descAreaUnidade;
    }
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getGrupoVinculacao() {
		return grupoVinculacao;
	}
	public void setGrupoVinculacao(String grupoVinculacao) {
		this.grupoVinculacao = grupoVinculacao;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
}
