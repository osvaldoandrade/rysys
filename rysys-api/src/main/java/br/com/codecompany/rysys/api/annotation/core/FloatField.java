package br.com.codecompany.rysys.api.annotation.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.FieldParser;
import br.com.codecompany.rysys.api.annotation.parser.FloatFieldParser;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD)
public @interface FloatField {
	
	// descreve se o campo eh utilizado apenas no request (TO_EIS),
	// apenas no result (FROM_EIS) ou ambos (FROM_TO_EIS)
	Direction direction() default Direction.TO_EIS;
	
	// ordem do campo na string final
	int index() default -1;
	
	// posicao inicial (usado no FROM_EIS)	
	int beginIndex() default 0;
	
	// tamanho final do campo
	int length() default -1;
	
	// precisao
	int precision();
	
	// char utilizado para preencher os espacos vazios	
	char filler() default '0';
}