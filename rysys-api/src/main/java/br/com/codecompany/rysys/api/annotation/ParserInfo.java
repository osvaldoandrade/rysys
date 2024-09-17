package br.com.codecompany.rysys.api.annotation;

import java.lang.annotation.Annotation;
import java.util.Set;

// retorna o parser correspondente a anotacao
public interface ParserInfo {
	// verifica se a anotacao eh valida para efetuar o parsing
	public boolean isValid(Class<? extends Annotation> annotation);
	public Set<Class<? extends Annotation>> validAnnotations();
	public Class<? extends FieldParser> getParser(Class<? extends Annotation> annotation);
}
