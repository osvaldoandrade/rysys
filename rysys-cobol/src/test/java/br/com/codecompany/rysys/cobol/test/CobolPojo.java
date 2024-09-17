package br.com.codecompany.rysys.cobol.test;

import static br.com.codecompany.rysys.api.annotation.Direction.FROM_TO_EIS;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.IntegerField;
import br.com.codecompany.rysys.api.annotation.core.TextField;

@DataDescriptor
public class CobolPojo {
	
	@TextField(index=1,length=10,direction=FROM_TO_EIS)
	private String nome;
	
	@TextField(index=2,length=10,beginIndex=10,direction=FROM_TO_EIS)
	private String sobrenome;
	
	@IntegerField(index=3,length=2,beginIndex=20,direction=FROM_TO_EIS)	
	private int idade;
	
	public CobolPojo(String nome, String sobrenome, int idade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public int getIdade() {
		return idade;
	}
}
