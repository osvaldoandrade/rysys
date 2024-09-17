package br.com.codecompany.rysys.api.function;

import java.lang.reflect.Constructor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FunctionFactory {

	private static final Logger log = LoggerFactory
			.getLogger(FunctionFactory.class);

	public static final Function getFunction(EisType eisType) {
		Function result = null;
		String className = eisType.getClassName();
		if (className != null) {
			try {
				Class<?> clazz = Class.forName(className);
				result = (Function) clazz.newInstance();
			} catch (Exception e) {
				log.error("Could not create function from type '" + className
						+ "'", e);
			}

		} else {
			throw new InvalidFunctionTypeException(
					"Not supported function type: '" + eisType + "'");
		}

		return result;
	}

        public static final Function getFunction(EisType eisType, String name, Object... optionalParams){
            return getFunction(eisType, "", name, optionalParams);
        }
        
	public static final Function getFunction(EisType eisType, String path, String name,
			Object... optionalParams) {

		Function result = null;

		if (!isValidName(name)) {
			throw new InvalidFunctionNameException("Invalid function name: '"
					+ name + "'");
		}

		String className = eisType.getClassName();
		if (className != null) {
			try {
				Class<?> clazz = Class.forName(className);

				Constructor<?> constructor;

				if (optionalParams.length == 0) {
					constructor = clazz.getConstructor(String.class, String.class);
					if (constructor == null) {
						throw new IllegalArgumentException("Class '"
								+ className + "' must have a constructor "
								+ "with two arguments of type String");
					}
					result = (Function) constructor.newInstance(path, name);
				} else {
					constructor = clazz.getConstructor(String.class,
							optionalParams.getClass());
					if (constructor == null) {
						throw new IllegalArgumentException("Class '"
								+ className + "' must have a constructor "
								+ "with first argument of type String");
					}
					result = (Function) constructor.newInstance(name,
							optionalParams);
				}

			} catch (Exception e) {
				log.error("Could not create function from type '" + className
						+ "'", e);
			}
		} else {
			throw new InvalidFunctionTypeException(
					"Not supported function type: '" + eisType + "'");
		}

		return result;
	}

	// nao aceita espacos em branco nem string vazia
	private static boolean isValidName(String name) {
		String expression = "\\S+";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}
}
