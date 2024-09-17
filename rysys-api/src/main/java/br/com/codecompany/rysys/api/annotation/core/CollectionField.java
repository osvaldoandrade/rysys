package br.com.codecompany.rysys.api.annotation.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

import br.com.codecompany.rysys.api.annotation.Direction;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD)
public @interface CollectionField {
	
	// descreve se o campo eh utilizado apenas no request (TO_EIS),
	// apenas no result (FROM_EIS) ou ambos (FROM_TO_EIS)
	Direction direction() default Direction.TO_EIS;
	
	// ordem do campo na string final
	int index() default -1;
	
	// posicao inicial do conjunto de caracteres que definem o total
	// de elementos da colecao (usado no FROM_EIS). Ex: AA43BBCCDD --> neste caso
	// existem 43 elementos e totalBeginIndex=2, pois o numero 43 comeca
	// na posicao '2' da string
	int totalBeginIndex(); 
	
	// quantidade de caracteres que definem o total de elementos da
	// colecao (usado no FROM_EIS). Ex: AA43BBCCDD --> neste caso existem 43
	// elementos e totalLength=2 pois '43' sao dois carateres
	int totalLength();

	// esse atributo so eh utilizado quando os indices sao calculados automaticamente
	// define o nome da propriedade que armazena o total de elementos da colecao
	// neste caso os atributos totalLength e totalBeginIndex sao ignorados
	// importante: a propriedade que armazena o total devera vir antes da colecao
	String totalFromProperty() default "";
	
	// posicao onde os dados da colecao residem. Caso nao seja informado,
	// serah considerado totalStart() + totalLength()
	int collectionStart() default -1;

    // define se o total de elementos da colecao sera colocado antes da
    // propria colecao. O tamanho da colecao sera formatado de acordo
    // com o atributo 'totalLength'
    boolean appendTotal() default true;
	
	// incremento de caracteres para cada registro. Depois que um elemento eh
	// preenchido o cursor 'pula' offset caracteres para efetuar o parsing do
	// proximo registro (usado no FROM_EIS)
	int elementOffset();
	
	// implementacao default da colecao (usado no FROM_EIS)
	@SuppressWarnings("unchecked")
	Class<? extends Collection> collectionType() default ArrayList.class;
	
	// tipo do elemento da colecao
	Class<?> elementType();
}
