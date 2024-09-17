package br.com.codecompany.rysys.api.function;

public final class ParserConfig {

	public static final ParserConfig DEFAULT_CONFIG =
			new ParserConfig(false, false, new String[]{});

	public static final ParserConfig AUTO_CALCULATE =
			new ParserConfig(true, false, new String[]{});

	public static final ParserConfig IGNORE_NULL =
			new ParserConfig(false, true, new String[]{});

	public static final ParserConfig AUTO_CALCULATE_IGNORE_NULL =
			new ParserConfig(true, true, new String[]{});

	private String[] fieldsToIgnore;
	private	boolean ignoreNullFields;
	private boolean autoCalculateBeginIndex;

	public ParserConfig(boolean autoCalculateBeginIndex,
			boolean ignoreNullFields, String... fieldsToIgnore) {
		this.autoCalculateBeginIndex = autoCalculateBeginIndex;
		this.ignoreNullFields = ignoreNullFields;
		this.fieldsToIgnore = fieldsToIgnore;
	}

	public ParserConfig(String... fieldsToIgnore) {
		this.fieldsToIgnore = fieldsToIgnore;
	}

	public String[] getFieldsToIgnore() {
		return fieldsToIgnore;
	}

	public boolean isIgnoreNullFields() {
		return ignoreNullFields;
	}

	public boolean isAutoCalculateBeginIndex() {
		return autoCalculateBeginIndex;
	}
}
