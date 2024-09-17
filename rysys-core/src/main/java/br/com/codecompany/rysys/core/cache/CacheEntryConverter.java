package br.com.codecompany.rysys.core.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CacheEntryConverter implements Converter {

	@SuppressWarnings("unchecked")
	public boolean canConvert(Class type) {
		return Map.class.isAssignableFrom(type);
	}

	@SuppressWarnings("unchecked")
	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		Map<String, CacheEntry> map = (Map<String, CacheEntry>) source;
		for (Entry<String, CacheEntry> entry : map.entrySet()) {
			CacheEntry value = entry.getValue();
			writer.startNode("entry");
			writer.addAttribute("request", entry.getKey());
			writer.addAttribute("maxTimeInCacheMillis", 
					String.valueOf(value.getMaxTimeInCacheMillis()));
			writer.endNode();
		}
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		Map<String, CacheEntry> map = 
			Collections.synchronizedMap(new HashMap<String, CacheEntry>());
		populateStringMap(reader, context, map);
		return map;
	}

	protected void populateStringMap(HierarchicalStreamReader reader,
			UnmarshallingContext context, Map<String, CacheEntry> map) {
		while (reader.hasMoreChildren()) {
			reader.moveDown();
			String request = reader.getAttribute("request");
			long maxTimeInCacheMillis = 
				Long.valueOf(reader.getAttribute("maxTimeInCacheMillis"));
			CacheEntry value = new CacheEntry();
			value.setMaxTimeInCacheMillis(maxTimeInCacheMillis);
			reader.moveUp();
			map.put(request, value);
		}
	}
}
