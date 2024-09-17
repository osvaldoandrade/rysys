package br.com.codecompany.rysys.core.cache;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.util.ResourceUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public final class Cache {
	
	private static final Logger log = LoggerFactory.getLogger(Cache.class);
	
	private static Cache INSTANCE = new Cache();
	
	private Map<String, CacheEntry> entries = 
		Collections.synchronizedMap(new HashMap<String, CacheEntry>());
	
	public static Cache getInstance() {
		return getInstance(null);
	}	
	
	public static Cache getInstance(String cacheConfigFile) {
		if (cacheConfigFile != null && !"".equals(cacheConfigFile.trim())) {
			try {
				log.info("Loading cache configuration from '" + cacheConfigFile + "'");
				InputStream stream = ResourceUtils.getResourceAsStream(INSTANCE, cacheConfigFile);
				XStream xstream = new XStream(new DomDriver());
			    xstream.registerConverter(new CacheEntryConverter());
			    xstream.autodetectAnnotations(true);
			    xstream.alias("entry", CacheEntry.class);
			    xstream.alias("cache", Cache.class);
			    Object object = xstream.fromXML(stream);
			    if (object != null) {
			    	INSTANCE = (Cache) object;
			    	log.info("Cache successfully loaded (" + (INSTANCE.entries == null? 0 : 
			    		INSTANCE.entries.size()) + " entries)");
			    }
			    else {
			    	log.warn("Could not load cache configuration");
			    }	
			} catch (Exception e) {
				log.warn("Error loading cache configuration", e);
			}
		}
		return INSTANCE;
	}
	
	// visivel apenas neste pacote
	private Cache() {
		
	}
	
	public boolean containsKey(String key) {
		return entries.containsKey(key);
	}
	
	public CacheEntry get(String key) {
		return entries.get(key);
	}
	
	public CacheEntry put(String key, CacheEntry value) {
		return entries.put(key, value);
	}
	
	public Map<String, CacheEntry> getEntries() {
		return entries;
	}
}
