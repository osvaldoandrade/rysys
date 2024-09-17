package br.com.codecompany.rysys.iso8583.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD)
public @interface Iso8583Bit {
	// numero do bit correspondente
	int value();
	// descricao do bit
	String description() default "";
}
