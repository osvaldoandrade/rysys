package br.com.codecompany.rysys.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectionUtils {

	private static final Logger log = LoggerFactory.getLogger(ReflectionUtils.class);

	public static final boolean isNumeric(Class<?> clazz) {
		return clazz.equals(short.class) ||
				clazz.equals(int.class) ||
				clazz.equals(long.class) ||
				clazz.equals(float.class) ||
				clazz.equals(double.class) ||
				Number.class.isAssignableFrom(clazz);
	}

	public static final boolean isPrimitive(Class<?> clazz) {
		return clazz.isPrimitive() ||
				clazz.equals(Boolean.class) ||
				clazz.equals(Byte.class) ||
				clazz.equals(Character.class) ||
				clazz.equals(Short.class) ||
				clazz.equals(Integer.class) ||
				clazz.equals(Long.class) ||
				clazz.equals(Float.class) ||
				clazz.equals(Double.class) ||
				clazz.equals(String.class) ||
				clazz.equals(BigDecimal.class);
	}

	public static final Object createPrimitive(Class<?> clazz, String elementAsString) {
		Object instance = null;

		if (clazz.equals(Boolean.class) || clazz.equals(boolean.class)) {
			instance = new Boolean(elementAsString);
		} else if (clazz.equals(Byte.class) || clazz.equals(byte.class)) {
			instance = new Byte(elementAsString);
		} else if (clazz.equals(Character.class) || clazz.equals(char.class)) {
			instance = new Character(elementAsString.charAt(0));
		} else if (clazz.equals(Short.class) || clazz.equals(short.class)) {
			instance = new Short(elementAsString);
		} else if (clazz.equals(Integer.class) || clazz.equals(int.class)) {
			instance = new Integer(elementAsString);
		} else if (clazz.equals(Long.class) || clazz.equals(long.class)) {
			instance = new Long(elementAsString);
		} else if (clazz.equals(Float.class) || clazz.equals(float.class)) {
			instance = new Float(elementAsString);
		} else if (clazz.equals(Double.class) || clazz.equals(double.class)) {
			instance = new Double(elementAsString);
		} else if (clazz.equals(String.class)) {
			instance = elementAsString;
		} else if (clazz.equals(BigDecimal.class)) {
			instance = new BigDecimal(elementAsString);
		} else {
			throw new IllegalArgumentException("Class '" +
					clazz.getName() + "' is not a valid primitive");
		}

		return instance;
	}

	// retorna todos os campos da classe e superclasses
	public static final Field[] allFields(Object obj) {
		Class<?> cls = obj.getClass();
		List<Field> accum = new LinkedList<Field>();
		while (cls != null) {
			Field[] f = cls.getDeclaredFields();
			for (int i = 0; i < f.length; i++) {
				accum.add(f[i]);
			}
			cls = cls.getSuperclass();
		}

		return (Field[]) accum.toArray(new Field[accum.size()]);
	}

	public static final Map<String, Object> describe(Object obj) {
		Class<?> cls = obj.getClass();
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		while (cls != null) {
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				try {
					field.setAccessible(true);
					int modifiers = field.getModifiers();
					// nao le as constantes
					if (!Modifier.isFinal(modifiers)) {
						map.put(name, field.get(obj));
					}
				} catch (Exception e) {
					log.warn("Could not read property '" +
							obj.getClass().getSimpleName() + "." + name + "'");
				}
			}
			cls = cls.getSuperclass();
		}
		return map;
	}

	public static final Object getValue(Object object, String property) {
		boolean found = false;
		Object value = null;
		Field[] all = allFields(object);
		try {
			for (Field field : all) {
				if (property.equals(field.getName())) {
					field.setAccessible(true);
					value = field.get(object);
					found = true;
					break;
				}
			}
			if (!found) {
				throw new IllegalArgumentException("Object " +
						object.getClass().getName() + " does not contain" +
						" property '" + property + "'");
			}
		} catch (Exception e) {
			log.error("Could not retrive the value of field " +
					object.getClass().getSimpleName() +
					"." + property + "'", e);
		}
		return value;
	}
}
