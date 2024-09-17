package br.com.codecompany.rysys.api.test.to;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.TextField;

@DataDescriptor
public class TipoJurosTO extends TransacaoTO {

	private static final long serialVersionUID = 7905269859695717486L;

	@IntegerField(beginIndex = 0, length = 1, direction = Direction.FROM_EIS)
	private int tpJuros;
	
	@TextField(beginIndex = 1, length = 40, direction = Direction.FROM_EIS)	
	private String descricaoTpJuros;

	public String getDescricaoTpJuros() {
		return descricaoTpJuros == null? null : descricaoTpJuros.toUpperCase();
	}

	public void setDescricaoTpJuros(String descricaoTpJuros) {
		this.descricaoTpJuros = descricaoTpJuros;
	}

	public int getTpJuros() {
		return tpJuros;
	}

	public void setTpJuros(int tpJuros) {
		this.tpJuros = tpJuros;
	}
}
