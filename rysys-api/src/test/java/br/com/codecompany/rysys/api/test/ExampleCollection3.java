package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.CollectionField;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.DateField;
import br.com.codecompany.rysys.api.annotation.core.DoubleField;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.TextField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DataDescriptor
public class ExampleCollection3 {

	@IntegerField(index=1, length=5)
	private int codigo;

	@TextField(index = 5, length=10)
	private String descricao;

	@DateField(index = 10, length=8, mask="yyyyMMdd")
	private Date data;

	@DoubleField(index = 15, length=6, precision=2)
	private Double valor;

	@CollectionField(index = 20,
					totalLength=2,
					elementType=ExampleEntry2.class,
					totalBeginIndex=-1,
					elementOffset=-1)
	private List<ExampleEntry2> list = new ArrayList<ExampleEntry2>();

    @TextField(index = 155, length=1, direction=Direction.FROM_TO_EIS)
    private String flagConfissaoDivida;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<ExampleEntry2> getList() {
		return list;
	}

	public void setList(List<ExampleEntry2> list) {
		this.list = list;
	}

	public String getFlagConfissaoDivida() {
		return flagConfissaoDivida;
	}

	public void setFlagConfissaoDivida(String flagConfissaoDivida) {
		this.flagConfissaoDivida = flagConfissaoDivida;
	}
}
