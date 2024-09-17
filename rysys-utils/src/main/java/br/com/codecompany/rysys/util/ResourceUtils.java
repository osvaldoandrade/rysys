package br.com.codecompany.rysys.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceUtils {
	
	private static final Logger log = LoggerFactory.getLogger(ResourceUtils.class);

	public static final InputStream getResourceAsStream(Object caller, String file) {
		log.debug("Trying to load '" + file
				+ "' using this.getClass().getClassLoader().getResourceAsStream()");
		InputStream stream = caller.getClass().getClassLoader().getResourceAsStream(file);

		if (stream == null) {
			log.debug("Load failed. Trying to load '" + file
					+ "' using Thread.currentThread().getContextClassLoader()." +
							"getResourceAsStream()");
			stream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(file);
		}

		if (stream == null) {
			log.debug("Load failed. Trying to load '" + file
					+ "' using FileInputStream(String)");
			try {
				stream = new FileInputStream(file);
			} catch (FileNotFoundException e) {

			}
		}

		if (stream == null) {
			log.debug("Load failed. Trying to load '" + file
					+ "' using FileInputStream(File)");
			try {
				stream = new FileInputStream(new File(file));
			} catch (FileNotFoundException e) {
				log.error("File not found", e);
			}
		}

		return stream;
	}
	
	public static final URL getResource(Object caller, String file) {
		log.debug("Trying to load '" + file
				+ "' using this.getClass().getClassLoader().getResource()");
		URL url = caller.getClass().getClassLoader().getResource(file);

		if (url == null) {
			log.debug("Load failed. Trying to load '" + file
					+ "' using Thread.currentThread().getContextClassLoader()." +
							"getResource()");
			url = Thread.currentThread().getContextClassLoader()
					.getResource(file);
		}

		if (url == null) {
			log.debug("Load failed. Trying to load '" + file
					+ "' using URL(String)");
			try {
				url = new URL(file);
			} catch (MalformedURLException e) {

			}
		}

		return url;
	}
}
