package br.com.codecompany.rysys.fgl.parser;

// $ANTLR 2.7.7 (2006-11-01): "fgl.g" -> "FGLParser.java"$

public interface FGLTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int IDENT = 4;
	int MAIN = 5;
	int END = 6;
	int DEFER = 7;
	int INTERRUPT = 8;
	int QUIT = 9;
	int RETURN = 10;
	int FUNCTION = 11;
	int LPAREN = 12;
	int RPAREN = 13;
	int COMMA = 14;
	int GLOBALS = 15;
	int DEFINE = 16;
	int ASSOCIATE = 17;
	int WITH = 18;
	int LIKE = 19;
	int DOT = 20;
	int TEXT = 21;
	int BYTE = 22;
	int BIGINT = 23;
	int INTEGER = 24;
	int INT = 25;
	int SMALLINT = 26;
	int REAL = 27;
	int SMALLFLOAT = 28;
	int DECIMAL = 29;
	int DEC = 30;
	int NUMERIC = 31;
	int MONEY = 32;
	int FLOAT = 33;
	int DOUBLE = 34;
	int VARCHAR = 35;
	int NVARCHAR = 36;
	int CHAR = 37;
	int NCHAR = 38;
	int CHARACTER = 39;
	int DATE = 40;
	int DATETIME = 41;
	int INTERVAL = 42;
	int YEAR = 43;
	int TO = 44;
	int MONTH = 45;
	int DAY = 46;
	int HOUR = 47;
	int MINUTE = 48;
	int SECOND = 49;
	int FRACTION = 50;
	int RECORD = 51;
	int STAR = 52;
	int LBRACK = 53;
	int RBRACK = 54;
	int ARRAY = 55;
	int OF = 56;
	int DYNAMIC = 57;
	int DIMENSIONS = 58;
	int STRING_LITERAL = 59;
	int COLON = 60;
	int SEMI = 61;
	int RUN = 62;
	int IN = 63;
	int FORM = 64;
	int MODE = 65;
	int LINE = 66;
	int WITHOUT = 67;
	int WAITING = 68;
	int RETURNING = 69;
	int LET = 70;
	int EQUAL = 71;
	int CALL = 72;
	int GOTO = 73;
	int TRUE = 74;
	int FALSE = 75;
	int OR = 76;
	int AND = 77;
	int NOT = 78;
	int ESC = 79;
	int QUOTED_STRING = 80;
	int BETWEEN = 81;
	int IS = 82;
	int NULL = 83;
	int ALL = 84;
	int ANY = 85;
	int EXISTS = 86;
	int PLUS = 87;
	int MINUS = 88;
	int AS = 89;
	int DIV = 90;
	int SLASH = 91;
	int DOUBLEVERTBAR = 92;
	int UNITS = 93;
	int DISTINCT = 94;
	int MOD = 95;
	int LENGTH = 96;
	int AVG = 97;
	int COUNT = 98;
	int MAX = 99;
	int MIN = 100;
	int SUM = 101;
	int DECODE = 102;
	int NVL = 103;
	int USER = 104;
	int NOT_EQUAL = 105;
	int LE = 106;
	int LT = 107;
	int GE = 108;
	int GT = 109;
	int MATCHES = 110;
	int CLIPPED = 111;
	int USING = 112;
	int GROUP = 113;
	int TODAY = 114;
	int WEEKDAY = 115;
	int MDY = 116;
	int COLUMN = 117;
	int EXTEND = 118;
	int TIME = 119;
	int INFIELD = 120;
	int PREPARE = 121;
	int THROUGH = 122;
	int THRU = 123;
	int IF = 124;
	int THEN = 125;
	int ELSE = 126;
	int WHILE = 127;
	int FOR = 128;
	int STEP = 129;
	int FOREACH = 130;
	int INTO = 131;
	int REOPTIMIZATION = 132;
	int CASE = 133;
	int WHEN = 134;
	int OTHERWISE = 135;
	int SLEEP = 136;
	int CONSTRUCT = 137;
	int DISPLAY = 138;
	int INPUT = 139;
	int MENU = 140;
	int REPORT = 141;
	int EXIT = 142;
	int PROGRAM = 143;
	int CONTINUE = 144;
	int ALLOCATE = 145;
	int LOCATE = 146;
	int MEMORY = 147;
	int FILE = 148;
	int DEALLOCATE = 149;
	int RESIZE = 150;
	int FREE = 151;
	int INITIALIZE = 152;
	int VALIDATE = 153;
	int PAGENO = 154;
	int LINENO = 155;
	int SPACE = 156;
	int SPACES = 157;
	int WORDWRAP = 158;
	int RIGHT = 159;
	int MARGIN = 160;
	int START = 161;
	int PIPE = 162;
	int PRINTER = 163;
	int LEFT = 164;
	int TOP = 165;
	int BOTTOM = 166;
	int PAGE = 167;
	int TERMINATE = 168;
	int FINISH = 169;
	int PAUSE = 170;
	int NEED = 171;
	int LINES = 172;
	int PRINT = 173;
	int SKIP = 174;
	int OUTPUT = 175;
	int SAME = 176;
	int BEFORE = 177;
	int AFTER = 178;
	int FIELD = 179;
	int ON = 180;
	int KEY = 181;
	int NEXT = 182;
	int PREVIOUS = 183;
	int REVERSE = 184;
	int BLINK = 185;
	int UNDERLINE = 186;
	int BLACK = 187;
	int BLUE = 188;
	int CYAN = 189;
	int GREEN = 190;
	int MAGENTA = 191;
	int RED = 192;
	int WHITE = 193;
	int YELLOW = 194;
	int BOLD = 195;
	int DIM = 196;
	int NORMAL = 197;
	int INVISIBLE = 198;
	int ATTRIBUTE = 199;
	int ATTRIBUTES = 200;
	int BY = 201;
	int NAME = 202;
	int FROM = 203;
	int HELP = 204;
	int AT = 205;
	int ERROR = 206;
	int MESSAGE = 207;
	int PROMPT = 208;
	int ROW = 209;
	int INSERT = 210;
	int DELETE = 211;
	int DEFAULTS = 212;
	int COMMAND = 213;
	int OPTION = 214;
	int SHOW = 215;
	int HIDE = 216;
	int FIRST = 217;
	int LAST = 218;
	int BORDER = 219;
	int COMMENT = 220;
	int OFF = 221;
	int WRAP = 222;
	int NO = 223;
	int ACCEPT = 224;
	int SQL = 225;
	int ORDER = 226;
	int CONSTRAINED = 227;
	int UNCONSTRAINED = 228;
	int OPTIONS = 229;
	int CLEAR = 230;
	int WINDOW = 231;
	int SCREEN = 232;
	int CLOSE = 233;
	int CURRENT = 234;
	int OPEN = 235;
	int ROWS = 236;
	int COLUMNS = 237;
	int SCROLL = 238;
	int UP = 239;
	int DOWN = 240;
	int DECLARE = 241;
	int CURSOR = 242;
	int HOLD = 243;
	int UPDATE = 244;
	int FETCH = 245;
	int PRIOR = 246;
	int RELATIVE = 247;
	int ABSOLUTE = 248;
	int FLUSH = 249;
	int PUT = 250;
	int TABLE = 251;
	int UNIQUE = 252;
	int CONSTRAINT = 253;
	int DROP = 254;
	int CREATE = 255;
	int TEMP = 256;
	int LOG = 257;
	int EXTENT = 258;
	int SIZE = 259;
	int LOCK = 260;
	int CLUSTER = 261;
	int INDEX = 262;
	int ASC = 263;
	int DESC = 264;
	int SELECT = 265;
	int ATSYMBOL = 266;
	int OUTER = 267;
	int UNION = 268;
	int WHERE = 269;
	int HAVING = 270;
	int LOAD = 271;
	int DELIMITER = 272;
	int UNLOAD = 273;
	int VALUES = 274;
	int SET = 275;
	int EXECUTE = 276;
	int SHARE = 277;
	int EXCLUSIVE = 278;
	int STATISTICS = 279;
	int WAIT = 280;
	int SECONDS = 281;
	int EXPLAIN = 282;
	int ISOLATION = 283;
	int STABILITY = 284;
	int DIRTY = 285;
	int COMMITTED = 286;
	int REPEATABLE = 287;
	int READ = 288;
	int BUFFERED = 289;
	int DATABASE = 290;
	int BEGIN = 291;
	int WORK = 292;
	int COMMIT = 293;
	int ROLLBACK = 294;
	int WHENEVER = 295;
	int FOUND = 296;
	int SQLERROR = 297;
	int SQLWARNING = 298;
	int WARNING = 299;
	int STOP = 300;
	int GO = 301;
	int EXTERNAL = 302;
	int FORMAT = 303;
	int EVERY = 304;
	int HEADER = 305;
	int TRAILER = 306;
	int NUM_INT = 307;
	int NUM_REAL = 308;
	int ASCII = 309;
	int INT_FLAG = 310;
	int NOTFOUND = 311;
	int STATUS = 312;
	int AGGREAGATE = 313;
	int ALL_ROWS = 314;
	int AVERAGE = 315;
	int CACHE = 316;
	int CHARARACTER = 317;
	int CHAR_LENGTH = 318;
	int CHECK = 319;
	int COMMITED = 320;
	int CONSTANT = 321;
	int COPY = 322;
	int CRCOLS = 323;
	int DEFAULT = 324;
	int DO = 325;
	int ESCAPE = 326;
	int EXEC = 327;
	int FIELD_TOUCHED = 328;
	int FIRST_ROWS = 329;
	int FORMONLY = 330;
	int GET_FLDBUF = 331;
	int INNER = 332;
	int INDICATOR = 333;
	int INSTRUCTIONS = 334;
	int ISNULL = 335;
	int JOIN = 336;
	int LABEL = 337;
	int LONG = 338;
	int MODULE = 339;
	int NEW = 340;
	int NOW = 341;
	int ORD = 342;
	int PERCENT = 343;
	int PRECISION = 344;
	int QUIT_FLAG = 345;
	int REMOVE = 346;
	int REPEAT = 347;
	int TABLES = 348;
	int TYPE = 349;
	int VIEW = 350;
	int WS = 351;
	int EOL = 352;
	int SL_COMMENT = 353;
	int SL_COMMENT_2 = 354;
	int COMMENT_1 = 355;
	int EXPONENT = 356;
	int HEX_DIGIT = 357;
	int VOCAB = 358;
}
