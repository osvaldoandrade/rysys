package br.com.codecompany.rysys.util;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class ToStringUtils {
	
	// esse campos nao terao valores exibidos
	private static final String[] FIELDS_TO_OMIT_VALUE = {"password"};
	private static final String OMITED_VALUE = "******";
	private static final Object[] FIELDS_TO_IGNORE = {"class", "serialVersionUID", "log", "logger"};
	
	public static final String toString(Set<Field> set) {
		if (set != null) {
			StringBuffer buffer = new StringBuffer("{");
			if (set.size() > 0) {
				Object[] array = set.toArray();
				int i = 0;
				Field field = null;
				while(i < array.length-1) {
					field = (Field) array[i++];
					buffer.append(field.getName()).append(",");
				}
				field = (Field) array[i];
				buffer.append(field.getName()).append("}");
				}
			else {
				buffer.append("}");
			}
			return buffer.toString();
		} else {
			return "Null received in ToStringUtils.toString(Set<Field>)";
		}
	}
	
	public static final String toString(Class<?>[] array) {
		if (array != null) {
			StringBuilder builder = new StringBuilder("\n");
			
			for (Class<?> clazz : array) {
				builder.append(clazz.getName()).append("\n");
			}
			
			removeLastNewLine(builder);
			
			return builder.toString();
		} else {
			return "Null received in ToStringUtils.toString(Class<?>[])";
		}
	}

	@SuppressWarnings("unchecked")
	public static final String toString(Map map) {
		if (map != null) {
			StringBuilder builder =  new StringBuilder("\n");
			
			// calcula o tamanho da maior chave
			int max = 0;
			Set<Object> keys = map.keySet();
			for (Object key : keys) {
				max = Math.max(max, String.valueOf(key).length());
			}
			
			max = max + 4;
			
			for (Object key : keys) {
				Object value = map.get(key);
				
				// ignora o campo?
				if (!ArrayUtils.contains(FIELDS_TO_IGNORE, key)) {
					
					// omite o valor do campo?
					if (ArrayUtils.contains(FIELDS_TO_OMIT_VALUE, key)) {
						value = OMITED_VALUE;
					}
				
					String name = String.valueOf(key) + " ";
					builder.append(StringUtils.rightPad(name, max, "."))
						.append(" [").append(value).append("]\n");
				}
			}
			
			removeLastNewLine(builder);
			
			return builder.toString();
		} else {
			return "Null received in ToStringUtils.toString(Map)";
		}
	}
	
	private static final void removeLastNewLine(StringBuilder builder) {
		if (builder.charAt(builder.length()-1) == '\n') {
			builder.deleteCharAt(builder.length()-1);
		}
	}
	
	public static final String toString(Object object) {
		if (object != null) {
			String result = "";
			if (object != null) {
				return toString(ReflectionUtils.describe(object));
			}
			return result;
		} else {
			return "Null received in ToStringUtils.toString(Object)";
		}		
	}
}
