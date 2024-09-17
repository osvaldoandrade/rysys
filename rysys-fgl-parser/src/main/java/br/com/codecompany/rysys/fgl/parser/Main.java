package br.com.codecompany.rysys.fgl.parser;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.codecompany.rysys.fgl.parser.transform.FglTransformer;


public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) throws IOException {
		if (args.length == 1) {
			String path = "";
			String[] files;
			File dir = new File(args[0]);
			if (dir.isDirectory()) {
				path = dir.getAbsolutePath() + File.separator;
				FilenameFilter filter = new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.toLowerCase().endsWith("4gl");
					}
				};
				files = dir.list(filter);
			} else {
				int index = dir.getAbsolutePath().lastIndexOf(File.separator);
				if (index >= 0) {
					path = dir.getAbsolutePath().substring(0, index+1);
				}
				files = new String[] { dir.getName() };
			}
			int i = 0;
			while (i < files.length) {
				transform(path, files, i++);
			}
			log.info("Processing finished. " + i + " files processed.");
		} else {
			System.err.println("Usage: java "
					+ Main.class.getSimpleName() + " <fgl_file|dir>");
		}
	}

	private static void transform(String path, String[] files, int i) {
		File input = new File(path + files[i]);
		String name = new File(files[i]).getName();
		File output = new File(path + "transformed_" + name);
		try {
			FglTransformer transformer = new FglTransformer(input, output);
			transformer.transform();
		} catch (Exception e) {
			log.error("Error transforming file", e);
		}
	}
}
