package br.com.codecompany.rysys.api.function;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class Types {
	
	public static final int UNKNOWN_TYPE = 0;
	
	public static final int FGL_INTEGER = 1;
	public static final int FGL_FLOAT = 2;
	public static final int FGL_STRING = 4;
	public static final int FGL_DATE = 5;

	public static final Map<Class<?>, Integer> FGL_TYPES = new HashMap<Class<?>, Integer>();

	static {
		FGL_TYPES.put(Boolean.class, UNKNOWN_TYPE);
		FGL_TYPES.put(boolean.class, UNKNOWN_TYPE);
		FGL_TYPES.put(Byte.class, UNKNOWN_TYPE);
		FGL_TYPES.put(byte.class, UNKNOWN_TYPE);
		FGL_TYPES.put(Short.class, FGL_INTEGER);
		FGL_TYPES.put(short.class, FGL_INTEGER);
		FGL_TYPES.put(Integer.class, FGL_INTEGER);
		FGL_TYPES.put(int.class, FGL_INTEGER);
		FGL_TYPES.put(Long.class, FGL_INTEGER);
		FGL_TYPES.put(long.class, FGL_INTEGER);
		FGL_TYPES.put(Float.class, FGL_FLOAT);
		FGL_TYPES.put(float.class, FGL_FLOAT);
		FGL_TYPES.put(Double.class, FGL_FLOAT);
		FGL_TYPES.put(double.class, FGL_FLOAT);
		FGL_TYPES.put(Character.class, FGL_STRING);
		FGL_TYPES.put(char.class, FGL_STRING);
		FGL_TYPES.put(String.class, FGL_STRING);
		FGL_TYPES.put(Date.class, FGL_DATE);
	}

	public static final Integer objectToType(Object object,
			Map<Class<?>, Integer> typesMap) {
		Class<?> clazz = object.getClass();
		Integer type = typesMap.get(clazz);
		if (type == null || type <= 0) {
			throw new IllegalArgumentException("The object type informed ("
					+ object + ") is not valid");
		} else {
			return type;
		}
	}
}
