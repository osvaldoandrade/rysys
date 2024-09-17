package br.com.codecompany.rysys.api.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotationUtils {
	
	private static final Logger log = LoggerFactory.getLogger(AnnotationUtils.class);
	
	public static final boolean exists(Annotation annotation, String methodName) {
		Method method = null;
		try {
			method = annotation.getClass().getMethod(methodName);
		} catch (Exception e) {
			
		}		
		return method != null;
	}
	
	public static final Object getValue(Annotation annotation, String methodName) {
		Object value = null;
		try {
			Method method = annotation.getClass().getMethod(methodName);
			value = method.invoke(annotation);
		} catch (NoSuchMethodException e) {
			log.error("Annotation " + annotation + 
					" does not contain " + methodName + "() method", e);
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		return value;
	}
	
	public static final long getLogValue(Annotation annotation, String methodName) {
		long value = 0;
		try {
			value = Long.valueOf(getStringValue(annotation, methodName));
		} catch (NumberFormatException e) {
			log.error(e.toString(), e);
		}
		return value;
	}
	
	public static final int getIntValue(Annotation annotation, String methodName) {
		return (int) getLogValue(annotation, methodName);
	}

	public static final String getStringValue(Annotation annotation, String methodName) {
		return String.valueOf(getValue(annotation, methodName));
	}

	public static final Class<?> getClassValue(Annotation annotation, String methodName) {
		return (Class<?>) getValue(annotation, methodName);
	}

	public static final char getCharValue(Annotation annotation, String methodName) {
		return getStringValue(annotation, methodName).charAt(0);
	}

	@SuppressWarnings("unchecked")
	public static final Enum getEnumValue(Annotation annotation, String methodName) {
		return (Enum) getValue(annotation, methodName);
	}

	public static final boolean getBooleanValue(Annotation annotation, String methodName) {
		return Boolean.parseBoolean(getStringValue(annotation, methodName));
	}

	public static final boolean isAnnotated(AnnotatedElement element, 
			Class<? extends Annotation> annotation) {
		
		boolean result = false;
		if (element != null) {
			Annotation[] annotations = element.getAnnotations();
			for (Annotation a : annotations) {
				if (annotation.getName().equals(a.annotationType().getName())) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
