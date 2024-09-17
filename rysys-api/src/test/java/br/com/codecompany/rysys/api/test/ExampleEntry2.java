/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.TextField;

/**
 *
 * @author fsp0065
 */
@DataDescriptor
public class ExampleEntry2 {

	@IntegerField(index = 5, length=2, direction=Direction.FROM_TO_EIS)
	private int codigo;
	
	@TextField(index = 10, length=8, direction=Direction.FROM_TO_EIS)
	private String descricao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    public ExampleEntry2() {

    }
    
	public ExampleEntry2(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
}
