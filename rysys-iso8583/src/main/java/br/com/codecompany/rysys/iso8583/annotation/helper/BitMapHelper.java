package br.com.codecompany.rysys.iso8583.annotation.helper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.api.annotation.ClassNotAnnotatedException;
import br.com.codecompany.rysys.api.annotation.NoPropertyAnnotatedException;
import br.com.codecompany.rysys.api.util.AnnotationUtils;
import br.com.codecompany.rysys.iso8583.annotation.Iso8583Bit;
import br.com.codecompany.rysys.iso8583.annotation.Iso8583BitMap;
import br.com.codecompany.rysys.iso8583.util.Iso8583MessageUtils;
import br.com.codecompany.rysys.util.ReflectionUtils;

public class BitMapHelper {
	
	private static final Logger log = LoggerFactory.getLogger(BitMapHelper.class);
	
	public static final Map<Integer, String> extractBitMap(Object bitMapObject) {
		if (AnnotationUtils.isAnnotated(bitMapObject.getClass(), Iso8583BitMap.class)) {
			int total = 0;
			Map<Integer, String> bitMap = new HashMap<Integer, String>();
			Field[] fields = ReflectionUtils.allFields(bitMapObject);
			for (Field field : fields) {
				if (AnnotationUtils.isAnnotated(field, Iso8583Bit.class)) {
					Iso8583Bit annotation = field.getAnnotation(Iso8583Bit.class);
					int bit = annotation.value();
					String description = annotation.description();
					
					// descricao do bit
					if (description != null && !"".equals(description.trim())) {
						Iso8583MessageUtils.descriptionMap.put(bit, description);
					}
					
					field.setAccessible(true);
					try {
						Object value = field.get(bitMapObject);
						if (value != null) {
							log.debug("Setting value '" + value + "' on bit " + bit);
							// associa o bit ao seu valor
							bitMap.put(bit, value.toString());
						}
						else {
							log.warn("Value of bit " + bit + " ignored (null)");
						}
					} catch (Exception e) {
						log.error("Error reading field " + bit, e);
					}
					total ++;
				}
			}
			if (total == 0) {
				throw new NoPropertyAnnotatedException("Class '" + 
						bitMapObject.getClass().getSimpleName() + 
						"' has no annotated property"); 
			}
			return bitMap;
		}
		else {
			throw new ClassNotAnnotatedException("Class '" + 
					bitMapObject.getClass().getSimpleName() + 
					"' does not contain @" + Iso8583BitMap.class.getSimpleName() +
					" annotation"); 
		}
	}
}
