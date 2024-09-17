package br.com.codecompany.rysys.fgl.parser;

// $ANTLR 2.7.7 (2006-11-01): "fgl.g" -> "FGLLexer.java"$

import java.io.InputStream;
import java.io.Reader;
import java.util.Hashtable;

import antlr.ANTLRHashString;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.InputBuffer;
import antlr.LexerSharedInputState;
import antlr.NoViableAltForCharException;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.collections.impl.BitSet;

@SuppressWarnings({"unchecked","unused"})
public class FGLLexer extends antlr.CharScanner implements FGLTokenTypes,
		TokenStream {
	
	public FGLLexer(InputStream in) {
		this(new ByteBuffer(in));
	}

	public FGLLexer(Reader in) {
		this(new CharBuffer(in));
	}

	public FGLLexer(InputBuffer ib) {
		this(new LexerSharedInputState(ib));
	}

	public FGLLexer(LexerSharedInputState state) {
		super(state);
		caseSensitiveLiterals = false;
		setCaseSensitive(false);
		literals = new Hashtable();
		literals.put(new ANTLRHashString("year", this), new Integer(43));
		literals.put(new ANTLRHashString("no", this), new Integer(223));
		literals.put(new ANTLRHashString("units", this), new Integer(93));
		literals.put(new ANTLRHashString("quit_flag", this), new Integer(345));
		literals.put(new ANTLRHashString("distinct", this), new Integer(94));
		literals.put(new ANTLRHashString("stop", this), new Integer(300));
		literals.put(new ANTLRHashString("mode", this), new Integer(65));
		literals.put(new ANTLRHashString("invisible", this), new Integer(198));
		literals.put(new ANTLRHashString("pipe", this), new Integer(162));
		literals.put(new ANTLRHashString("cache", this), new Integer(316));
		literals.put(new ANTLRHashString("tables", this), new Integer(348));
		literals.put(new ANTLRHashString("first_rows", this), new Integer(329));
		literals.put(new ANTLRHashString("at", this), new Integer(205));
		literals.put(new ANTLRHashString("accept", this), new Integer(224));
		literals.put(new ANTLRHashString("exit", this), new Integer(142));
		literals.put(new ANTLRHashString("is", this), new Integer(82));
		literals.put(new ANTLRHashString("average", this), new Integer(315));
		literals.put(new ANTLRHashString("cyan", this), new Integer(189));
		literals.put(new ANTLRHashString("as", this), new Integer(89));
		literals.put(new ANTLRHashString("end", this), new Integer(6));
		literals.put(new ANTLRHashString("create", this), new Integer(255));
		literals.put(new ANTLRHashString("finish", this), new Integer(169));
		literals.put(new ANTLRHashString("help", this), new Integer(204));
		literals.put(new ANTLRHashString("top", this), new Integer(165));
		literals.put(new ANTLRHashString("header", this), new Integer(305));
		literals.put(new ANTLRHashString("today", this), new Integer(114));
		literals.put(new ANTLRHashString("bold", this), new Integer(195));
		literals.put(new ANTLRHashString("execute", this), new Integer(276));
		literals.put(new ANTLRHashString("int", this), new Integer(25));
		literals.put(new ANTLRHashString("declare", this), new Integer(241));
		literals.put(new ANTLRHashString("dec", this), new Integer(30));
		literals.put(new ANTLRHashString("whenever", this), new Integer(295));
		literals.put(new ANTLRHashString("explain", this), new Integer(282));
		literals.put(new ANTLRHashString("weekday", this), new Integer(115));
		literals.put(new ANTLRHashString("pageno", this), new Integer(154));
		literals.put(new ANTLRHashString("in", this), new Integer(63));
		literals.put(new ANTLRHashString("option", this), new Integer(214));
		literals.put(new ANTLRHashString("lock", this), new Integer(260));
		literals.put(new ANTLRHashString("otherwise", this), new Integer(135));
		literals.put(new ANTLRHashString("message", this), new Integer(207));
		literals.put(new ANTLRHashString("mod", this), new Integer(95));
		literals.put(new ANTLRHashString("screen", this), new Integer(232));
		literals.put(new ANTLRHashString("run", this), new Integer(62));
		literals.put(new ANTLRHashString("unload", this), new Integer(273));
		literals.put(new ANTLRHashString("close", this), new Integer(233));
		literals.put(new ANTLRHashString("left", this), new Integer(164));
		literals.put(new ANTLRHashString("day", this), new Integer(46));
		literals.put(new ANTLRHashString("extent", this), new Integer(258));
		literals.put(new ANTLRHashString("underline", this), new Integer(186));
		literals.put(new ANTLRHashString("reoptimization", this), new Integer(
				132));
		literals.put(new ANTLRHashString("sleep", this), new Integer(136));
		literals.put(new ANTLRHashString("where", this), new Integer(269));
		literals.put(new ANTLRHashString("group", this), new Integer(113));
		literals.put(new ANTLRHashString("found", this), new Integer(296));
		literals.put(new ANTLRHashString("nvl", this), new Integer(103));
		literals.put(new ANTLRHashString("statitics", this), new Integer(279));
		literals.put(new ANTLRHashString("lineno", this), new Integer(155));
		literals.put(new ANTLRHashString("prepare", this), new Integer(121));
		literals.put(new ANTLRHashString("decode", this), new Integer(102));
		literals.put(new ANTLRHashString("every", this), new Integer(304));
		literals.put(new ANTLRHashString("union", this), new Integer(268));
		literals.put(new ANTLRHashString("nvarchar", this), new Integer(36));
		literals.put(new ANTLRHashString("hold", this), new Integer(243));
		literals.put(new ANTLRHashString("from", this), new Integer(203));
		literals.put(new ANTLRHashString("continue", this), new Integer(144));
		literals.put(new ANTLRHashString("to", this), new Integer(44));
		literals.put(new ANTLRHashString("sqlerror", this), new Integer(297));
		literals.put(new ANTLRHashString("right", this), new Integer(159));
		literals.put(new ANTLRHashString("record", this), new Integer(51));
		literals.put(new ANTLRHashString("do", this), new Integer(325));
		literals.put(new ANTLRHashString("clear", this), new Integer(230));
		literals.put(new ANTLRHashString("any", this), new Integer(85));
		literals.put(new ANTLRHashString("terminate", this), new Integer(168));
		literals.put(new ANTLRHashString("initialize", this), new Integer(152));
		literals.put(new ANTLRHashString("update", this), new Integer(244));
		literals.put(new ANTLRHashString("field_touched", this), new Integer(
				328));
		literals.put(new ANTLRHashString("thru", this), new Integer(123));
		literals.put(new ANTLRHashString("index", this), new Integer(262));
		literals
				.put(new ANTLRHashString("constrained", this), new Integer(227));
		literals.put(new ANTLRHashString("through", this), new Integer(122));
		literals.put(new ANTLRHashString("options", this), new Integer(229));
		literals.put(new ANTLRHashString("repeat", this), new Integer(347));
		literals.put(new ANTLRHashString("sql", this), new Integer(225));
		literals.put(new ANTLRHashString("by", this), new Integer(201));
		literals.put(new ANTLRHashString("if", this), new Integer(124));
		literals.put(new ANTLRHashString("remove", this), new Integer(346));
		literals.put(new ANTLRHashString("white", this), new Integer(193));
		literals.put(new ANTLRHashString("or", this), new Integer(76));
		literals.put(new ANTLRHashString("notfound", this), new Integer(311));
		literals.put(new ANTLRHashString("hour", this), new Integer(47));
		literals.put(new ANTLRHashString("after", this), new Integer(178));
		literals.put(new ANTLRHashString("while", this), new Integer(127));
		literals.put(new ANTLRHashString("inner", this), new Integer(332));
		literals.put(new ANTLRHashString("smalfloat", this), new Integer(28));
		literals.put(new ANTLRHashString("time", this), new Integer(119));
		literals.put(new ANTLRHashString("bigint", this), new Integer(23));
		literals.put(new ANTLRHashString("select", this), new Integer(265));
		literals.put(new ANTLRHashString("int_flag", this), new Integer(310));
		literals.put(new ANTLRHashString("green", this), new Integer(190));
		literals.put(new ANTLRHashString("status", this), new Integer(312));
		literals.put(new ANTLRHashString("isolation", this), new Integer(283));
		literals.put(new ANTLRHashString("column", this), new Integer(117));
		literals.put(new ANTLRHashString("window", this), new Integer(231));
		literals.put(new ANTLRHashString("escape", this), new Integer(326));
		literals.put(new ANTLRHashString("commit", this), new Integer(293));
		literals.put(new ANTLRHashString("user", this), new Integer(104));
		literals.put(new ANTLRHashString("long", this), new Integer(338));
		literals.put(new ANTLRHashString("percent", this), new Integer(343));
		literals.put(new ANTLRHashString("order", this), new Integer(226));
		literals.put(new ANTLRHashString("crcols", this), new Integer(323));
		literals.put(new ANTLRHashString("between", this), new Integer(81));
		literals.put(new ANTLRHashString("delimiter", this), new Integer(272));
		literals.put(new ANTLRHashString("infield", this), new Integer(120));
		literals.put(new ANTLRHashString("now", this), new Integer(341));
		literals.put(new ANTLRHashString("go", this), new Integer(301));
		literals.put(new ANTLRHashString("red", this), new Integer(192));
		literals.put(new ANTLRHashString("on", this), new Integer(180));
		literals.put(new ANTLRHashString("wordwrap", this), new Integer(158));
		literals.put(new ANTLRHashString("resize", this), new Integer(150));
		literals.put(new ANTLRHashString("float", this), new Integer(33));
		literals.put(new ANTLRHashString("attribute", this), new Integer(199));
		literals.put(new ANTLRHashString("warning", this), new Integer(299));
		literals.put(new ANTLRHashString("main", this), new Integer(5));
		literals.put(new ANTLRHashString("table", this), new Integer(251));
		literals.put(new ANTLRHashString("constraint", this), new Integer(253));
		literals.put(new ANTLRHashString("dim", this), new Integer(196));
		literals.put(new ANTLRHashString("format", this), new Integer(303));
		literals.put(new ANTLRHashString("all_rows", this), new Integer(314));
		literals.put(new ANTLRHashString("program", this), new Integer(143));
		literals.put(new ANTLRHashString("attributes", this), new Integer(200));
		literals.put(new ANTLRHashString("columns", this), new Integer(237));
		literals.put(new ANTLRHashString("yellow", this), new Integer(194));
		literals.put(new ANTLRHashString("skip", this), new Integer(174));
		literals.put(new ANTLRHashString("not", this), new Integer(78));
		literals.put(new ANTLRHashString("length", this), new Integer(96));
		literals.put(new ANTLRHashString("without", this), new Integer(67));
		literals.put(new ANTLRHashString("integer", this), new Integer(24));
		literals.put(new ANTLRHashString("name", this), new Integer(202));
		literals.put(new ANTLRHashString("input", this), new Integer(139));
		literals.put(new ANTLRHashString("aggregate", this), new Integer(313));
		literals.put(new ANTLRHashString("smallint", this), new Integer(26));
		literals.put(new ANTLRHashString("drop", this), new Integer(254));
		literals.put(new ANTLRHashString("start", this), new Integer(161));
		literals.put(new ANTLRHashString("constant", this), new Integer(321));
		literals.put(new ANTLRHashString("second", this), new Integer(49));
		literals.put(new ANTLRHashString("allocate", this), new Integer(145));
		literals.put(new ANTLRHashString("ord", this), new Integer(342));
		literals.put(new ANTLRHashString("share", this), new Integer(277));
		literals.put(new ANTLRHashString("define", this), new Integer(16));
		literals.put(new ANTLRHashString("date", this), new Integer(40));
		literals.put(new ANTLRHashString("values", this), new Integer(274));
		literals.put(new ANTLRHashString("numeric", this), new Integer(31));
		literals.put(new ANTLRHashString("border", this), new Integer(219));
		literals.put(new ANTLRHashString("cursor", this), new Integer(242));
		literals.put(new ANTLRHashString("delete", this), new Integer(211));
		literals.put(new ANTLRHashString("menu", this), new Integer(140));
		literals.put(new ANTLRHashString("extend", this), new Integer(118));
		literals.put(new ANTLRHashString("commited", this), new Integer(320));
		literals.put(new ANTLRHashString("open", this), new Integer(235));
		literals.put(new ANTLRHashString("let", this), new Integer(70));
		literals.put(new ANTLRHashString("error", this), new Integer(206));
		literals.put(new ANTLRHashString("log", this), new Integer(257));
		literals.put(new ANTLRHashString("copy", this), new Integer(322));
		literals.put(new ANTLRHashString("matches", this), new Integer(110));
		literals.put(new ANTLRHashString("desc", this), new Integer(264));
		literals.put(new ANTLRHashString("max", this), new Integer(99));
		literals.put(new ANTLRHashString("bottom", this), new Integer(166));
		literals.put(new ANTLRHashString("character", this), new Integer(317));
		literals.put(new ANTLRHashString("previous", this), new Integer(183));
		literals.put(new ANTLRHashString("blink", this), new Integer(185));
		literals.put(new ANTLRHashString("external", this), new Integer(302));
		literals.put(new ANTLRHashString("load", this), new Integer(271));
		literals.put(new ANTLRHashString("of", this), new Integer(56));
		literals.put(new ANTLRHashString("foreach", this), new Integer(130));
		literals.put(new ANTLRHashString("getfldbuf", this), new Integer(331));
		literals.put(new ANTLRHashString("then", this), new Integer(125));
		literals.put(new ANTLRHashString("quit", this), new Integer(9));
		literals.put(new ANTLRHashString("insert", this), new Integer(210));
		literals.put(new ANTLRHashString("asc", this), new Integer(263));
		literals.put(new ANTLRHashString("ascii", this), new Integer(309));
		literals.put(new ANTLRHashString("form", this), new Integer(64));
		literals.put(new ANTLRHashString("report", this), new Integer(141));
		literals.put(new ANTLRHashString("up", this), new Integer(239));
		literals.put(new ANTLRHashString("instructions", this),
				new Integer(334));
		literals.put(new ANTLRHashString("rollback", this), new Integer(294));
		literals.put(new ANTLRHashString("isnull", this), new Integer(335));
		literals.put(new ANTLRHashString("real", this), new Integer(27));
		literals.put(new ANTLRHashString("avg", this), new Integer(97));
		literals.put(new ANTLRHashString("defaults", this), new Integer(212));
		literals.put(new ANTLRHashString("rows", this), new Integer(236));
		literals.put(new ANTLRHashString("next", this), new Integer(182));
		literals.put(new ANTLRHashString("magenta", this), new Integer(191));
		literals.put(new ANTLRHashString("join", this), new Integer(336));
		literals.put(new ANTLRHashString("count", this), new Integer(98));
		literals.put(new ANTLRHashString("mdy", this), new Integer(116));
		literals.put(new ANTLRHashString("when", this), new Integer(134));
		literals.put(new ANTLRHashString("new", this), new Integer(340));
		literals.put(new ANTLRHashString("goto", this), new Integer(73));
		literals.put(new ANTLRHashString("true", this), new Integer(74));
		literals.put(new ANTLRHashString("decimal", this), new Integer(29));
		literals
				.put(new ANTLRHashString("char_length", this), new Integer(318));
		literals.put(new ANTLRHashString("blue", this), new Integer(188));
		literals.put(new ANTLRHashString("free", this), new Integer(151));
		literals.put(new ANTLRHashString("current", this), new Integer(234));
		literals.put(new ANTLRHashString("set", this), new Integer(275));
		literals.put(new ANTLRHashString("last", this), new Integer(218));
		literals.put(new ANTLRHashString("hide", this), new Integer(216));
		literals.put(new ANTLRHashString("normal", this), new Integer(197));
		literals.put(new ANTLRHashString("clipped", this), new Integer(111));
		literals.put(new ANTLRHashString("view", this), new Integer(350));
		literals.put(new ANTLRHashString("and", this), new Integer(77));
		literals.put(new ANTLRHashString("return", this), new Integer(10));
		literals.put(new ANTLRHashString("black", this), new Integer(187));
		literals.put(new ANTLRHashString("fraction", this), new Integer(50));
		literals.put(new ANTLRHashString("work", this), new Integer(292));
		literals.put(new ANTLRHashString("database", this), new Integer(290));
		literals.put(new ANTLRHashString("down", this), new Integer(240));
		literals.put(new ANTLRHashString("like", this), new Integer(19));
		literals.put(new ANTLRHashString("check", this), new Integer(319));
		literals.put(new ANTLRHashString("min", this), new Integer(100));
		literals.put(new ANTLRHashString("false", this), new Integer(75));
		literals.put(new ANTLRHashString("space", this), new Integer(156));
		literals.put(new ANTLRHashString("print", this), new Integer(173));
		literals.put(new ANTLRHashString("temp", this), new Integer(256));
		literals.put(new ANTLRHashString("for", this), new Integer(128));
		literals.put(new ANTLRHashString("default", this), new Integer(324));
		literals.put(new ANTLRHashString("unique", this), new Integer(252));
		literals.put(new ANTLRHashString("deallocate", this), new Integer(149));
		literals.put(new ANTLRHashString("row", this), new Integer(209));
		literals.put(new ANTLRHashString("returning", this), new Integer(69));
		literals.put(new ANTLRHashString("scroll", this), new Integer(238));
		literals.put(new ANTLRHashString("case", this), new Integer(133));
		literals.put(new ANTLRHashString("repeatable", this), new Integer(287));
		literals.put(new ANTLRHashString("show", this), new Integer(215));
		literals.put(new ANTLRHashString("waiting", this), new Integer(68));
		literals.put(new ANTLRHashString("text", this), new Integer(21));
		literals.put(new ANTLRHashString("into", this), new Integer(131));
		literals.put(new ANTLRHashString("null", this), new Integer(83));
		literals.put(new ANTLRHashString("read", this), new Integer(288));
		literals.put(new ANTLRHashString("nchar", this), new Integer(38));
		literals.put(new ANTLRHashString("lines", this), new Integer(172));
		literals.put(new ANTLRHashString("all", this), new Integer(84));
		literals.put(new ANTLRHashString("sum", this), new Integer(101));
		literals.put(new ANTLRHashString("using", this), new Integer(112));
		literals.put(new ANTLRHashString("array", this), new Integer(55));
		literals.put(new ANTLRHashString("having", this), new Integer(270));
		literals.put(new ANTLRHashString("exists", this), new Integer(86));
		literals.put(new ANTLRHashString("display", this), new Integer(138));
		literals.put(new ANTLRHashString("key", this), new Integer(181));
		literals.put(new ANTLRHashString("sqlwarning", this), new Integer(298));
		literals.put(new ANTLRHashString("interrupt", this), new Integer(8));
		literals.put(new ANTLRHashString("double", this), new Integer(34));
		literals.put(new ANTLRHashString("size", this), new Integer(259));
		literals.put(new ANTLRHashString("precision", this), new Integer(344));
		literals.put(new ANTLRHashString("first", this), new Integer(217));
		literals.put(new ANTLRHashString("associate", this), new Integer(17));
		literals.put(new ANTLRHashString("line", this), new Integer(66));
		literals.put(new ANTLRHashString("stability", this), new Integer(284));
		literals.put(new ANTLRHashString("need", this), new Integer(171));
		literals.put(new ANTLRHashString("month", this), new Integer(45));
		literals.put(new ANTLRHashString("absolute", this), new Integer(248));
		literals.put(new ANTLRHashString("field", this), new Integer(179));
		literals.put(new ANTLRHashString("fetch", this), new Integer(245));
		literals.put(new ANTLRHashString("command", this), new Integer(213));
		literals.put(new ANTLRHashString("output", this), new Integer(175));
		literals.put(new ANTLRHashString("wait", this), new Integer(280));
		literals.put(new ANTLRHashString("put", this), new Integer(250));
		literals.put(new ANTLRHashString("prompt", this), new Integer(208));
		literals.put(new ANTLRHashString("exclusive", this), new Integer(278));
		literals.put(new ANTLRHashString("cluster", this), new Integer(261));
		literals.put(new ANTLRHashString("locate", this), new Integer(146));
		literals.put(new ANTLRHashString("dymanic", this), new Integer(57));
		literals.put(new ANTLRHashString("money", this), new Integer(32));
		literals.put(new ANTLRHashString("exec", this), new Integer(327));
		literals.put(new ANTLRHashString("comment", this), new Integer(220));
		literals.put(new ANTLRHashString("trailer", this), new Integer(306));
		literals.put(new ANTLRHashString("char", this), new Integer(37));
		literals.put(new ANTLRHashString("outer", this), new Integer(267));
		literals.put(new ANTLRHashString("indicator", this), new Integer(333));
		literals.put(new ANTLRHashString("page", this), new Integer(167));
		literals.put(new ANTLRHashString("unconstrained", this), new Integer(
				228));
		literals.put(new ANTLRHashString("globals", this), new Integer(15));
		literals.put(new ANTLRHashString("buffered", this), new Integer(289));
		literals.put(new ANTLRHashString("type", this), new Integer(349));
		literals.put(new ANTLRHashString("validate", this), new Integer(153));
		literals.put(new ANTLRHashString("construct", this), new Integer(137));
		literals.put(new ANTLRHashString("begin", this), new Integer(291));
		literals.put(new ANTLRHashString("pause", this), new Integer(170));
		literals.put(new ANTLRHashString("flush", this), new Integer(249));
		literals.put(new ANTLRHashString("defer", this), new Integer(7));
		literals.put(new ANTLRHashString("reverse", this), new Integer(184));
		literals.put(new ANTLRHashString("dirty", this), new Integer(285));
		literals.put(new ANTLRHashString("function", this), new Integer(11));
		literals.put(new ANTLRHashString("spaces", this), new Integer(157));
		literals.put(new ANTLRHashString("file", this), new Integer(148));
		literals.put(new ANTLRHashString("off", this), new Integer(221));
		literals.put(new ANTLRHashString("dimensions", this), new Integer(58));
		literals.put(new ANTLRHashString("module", this), new Integer(339));
		literals.put(new ANTLRHashString("label", this), new Integer(337));
		literals.put(new ANTLRHashString("with", this), new Integer(18));
		literals.put(new ANTLRHashString("relative", this), new Integer(247));
		literals.put(new ANTLRHashString("interval", this), new Integer(42));
		literals.put(new ANTLRHashString("before", this), new Integer(177));
		literals.put(new ANTLRHashString("formonly", this), new Integer(330));
		literals.put(new ANTLRHashString("varchar", this), new Integer(35));
		literals.put(new ANTLRHashString("byte", this), new Integer(22));
		literals.put(new ANTLRHashString("else", this), new Integer(126));
		literals.put(new ANTLRHashString("printer", this), new Integer(163));
		literals.put(new ANTLRHashString("datetime", this), new Integer(41));
		literals.put(new ANTLRHashString("margin", this), new Integer(160));
		literals.put(new ANTLRHashString("minute", this), new Integer(48));
		literals.put(new ANTLRHashString("call", this), new Integer(72));
	}

	public Token nextToken() throws TokenStreamException {
		Token theRetToken = null;
		tryAgain: for (;;) {
			Token _token = null;
			int _ttype = Token.INVALID_TYPE;
			resetText();
			try { // for char stream error handling
				try { // for lexical error handling
					switch (LA(1)) {
					case '+': {
						mPLUS(true);
						theRetToken = _returnToken;
						break;
					}
					case '*': {
						mSTAR(true);
						theRetToken = _returnToken;
						break;
					}
					case '/': {
						mSLASH(true);
						theRetToken = _returnToken;
						break;
					}
					case ',': {
						mCOMMA(true);
						theRetToken = _returnToken;
						break;
					}
					case ';': {
						mSEMI(true);
						theRetToken = _returnToken;
						break;
					}
					case ':': {
						mCOLON(true);
						theRetToken = _returnToken;
						break;
					}
					case '=': {
						mEQUAL(true);
						theRetToken = _returnToken;
						break;
					}
					case '!':
					case '<':
					case '^': {
						mNOT_EQUAL(true);
						theRetToken = _returnToken;
						break;
					}
					case '>': {
						mGT(true);
						theRetToken = _returnToken;
						break;
					}
					case '(': {
						mLPAREN(true);
						theRetToken = _returnToken;
						break;
					}
					case ')': {
						mRPAREN(true);
						theRetToken = _returnToken;
						break;
					}
					case '[': {
						mLBRACK(true);
						theRetToken = _returnToken;
						break;
					}
					case ']': {
						mRBRACK(true);
						theRetToken = _returnToken;
						break;
					}
					case '@': {
						mATSYMBOL(true);
						theRetToken = _returnToken;
						break;
					}
					case '|': {
						mDOUBLEVERTBAR(true);
						theRetToken = _returnToken;
						break;
					}
					case '\t':
					case '\u000c':
					case ' ': {
						mWS(true);
						theRetToken = _returnToken;
						break;
					}
					case '\n':
					case '\r': {
						mEOL(true);
						theRetToken = _returnToken;
						break;
					}
					case '#': {
						mSL_COMMENT(true);
						theRetToken = _returnToken;
						break;
					}
					case '{': {
						mCOMMENT_1(true);
						theRetToken = _returnToken;
						break;
					}
					case '_':
					case 'a':
					case 'b':
					case 'c':
					case 'd':
					case 'e':
					case 'f':
					case 'g':
					case 'h':
					case 'i':
					case 'j':
					case 'k':
					case 'l':
					case 'm':
					case 'n':
					case 'o':
					case 'p':
					case 'q':
					case 'r':
					case 's':
					case 't':
					case 'u':
					case 'v':
					case 'w':
					case 'x':
					case 'y':
					case 'z': {
						mIDENT(true);
						theRetToken = _returnToken;
						break;
					}
					case '"':
					case '\'': {
						mSTRING_LITERAL(true);
						theRetToken = _returnToken;
						break;
					}
					case '.':
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9': {
						mNUM_INT(true);
						theRetToken = _returnToken;
						break;
					}
					default:
						if ((LA(1) == '-') && (LA(2) == '-')) {
							mSL_COMMENT_2(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '-') && (true)) {
							mMINUS(true);
							theRetToken = _returnToken;
						} else {
							if (LA(1) == EOF_CHAR) {
								uponEOF();
								_returnToken = makeToken(Token.EOF_TYPE);
							} else {
								throw new NoViableAltForCharException(
										(char) LA(1), getFilename(), getLine(),
										getColumn());
							}
						}
					}
					if (_returnToken == null)
						continue tryAgain; // found SKIP token
					_ttype = _returnToken.getType();
					_returnToken.setType(_ttype);
					return _returnToken;
				} catch (RecognitionException e) {
					throw new TokenStreamRecognitionException(e);
				}
			} catch (CharStreamException cse) {
				if (cse instanceof CharStreamIOException) {
					throw new TokenStreamIOException(
							((CharStreamIOException) cse).io);
				} else {
					throw new TokenStreamException(cse.getMessage());
				}
			}
		}
	}

	public final void mPLUS(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = PLUS;
		int _saveIndex;

		match('+');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mMINUS(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = MINUS;
		int _saveIndex;

		match('-');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mSTAR(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = STAR;
		int _saveIndex;

		match('*');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mSLASH(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = SLASH;
		int _saveIndex;

		match('/');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mCOMMA(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = COMMA;
		int _saveIndex;

		match(',');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mSEMI(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = SEMI;
		int _saveIndex;

		match(';');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mCOLON(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = COLON;
		int _saveIndex;

		match(':');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mEQUAL(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = EQUAL;
		int _saveIndex;

		match('=');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mNOT_EQUAL(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = NOT_EQUAL;
		int _saveIndex;

		switch (LA(1)) {
		case '<': {
			match('<');
			_ttype = LT;
			{
				switch (LA(1)) {
				case '>': {
					{
						match('>');
						_ttype = NOT_EQUAL;
					}
					break;
				}
				case '=': {
					{
						match('=');
						_ttype = LE;
					}
					break;
				}
				default: {
				}
				}
			}
			break;
		}
		case '!': {
			match("!=");
			break;
		}
		case '^': {
			match("^=");
			break;
		}
		default: {
			throw new NoViableAltForCharException((char) LA(1), getFilename(),
					getLine(), getColumn());
		}
		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mGT(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = GT;
		int _saveIndex;

		match('>');
		{
			if ((LA(1) == '=')) {
				match('=');
				_ttype = GE;
			} else {
			}

		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mLPAREN(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = LPAREN;
		int _saveIndex;

		match('(');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mRPAREN(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = RPAREN;
		int _saveIndex;

		match(')');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mLBRACK(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = LBRACK;
		int _saveIndex;

		match('[');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mRBRACK(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = RBRACK;
		int _saveIndex;

		match(']');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mATSYMBOL(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ATSYMBOL;
		int _saveIndex;

		match('@');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mDOUBLEVERTBAR(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = DOUBLEVERTBAR;
		int _saveIndex;

		match("||");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mWS(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = WS;
		int _saveIndex;

		{
			int _cnt750 = 0;
			_loop750: do {
				switch (LA(1)) {
				case ' ': {
					match(' ');
					break;
				}
				case '\t': {
					match('\t');
					break;
				}
				case '\u000c': {
					match('\f');
					break;
				}
				default: {
					if (_cnt750 >= 1) {
						break _loop750;
					} else {
						throw new NoViableAltForCharException((char) LA(1),
								getFilename(), getLine(), getColumn());
					}
				}
				}
				_cnt750++;
			} while (true);
		}
		_ttype = Token.SKIP;
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mEOL(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = EOL;
		int _saveIndex;

		{
			if ((LA(1) == '\r') && (LA(2) == '\n')) {
				match("\r\n");
			} else if ((LA(1) == '\r') && (true)) {
				match('\r');
			} else if ((LA(1) == '\n')) {
				match('\n');
			} else {
				throw new NoViableAltForCharException((char) LA(1),
						getFilename(), getLine(), getColumn());
			}

		}
		_ttype = Token.SKIP;
		newline();
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mSL_COMMENT(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = SL_COMMENT;
		int _saveIndex;

		match("#");
		{
			_loop756: do {
				if ((_tokenSet_0.member(LA(1)))) {
					{
						match(_tokenSet_0);
					}
				} else {
					break _loop756;
				}

			} while (true);
		}
		{
			switch (LA(1)) {
			case '\n': {
				match('\n');
				break;
			}
			case '\r': {
				match('\r');
				{
					if ((LA(1) == '\n')) {
						match('\n');
					} else {
					}

				}
				break;
			}
			default: {
				throw new NoViableAltForCharException((char) LA(1),
						getFilename(), getLine(), getColumn());
			}
			}
		}
		_ttype = Token.SKIP;
		newline();
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mSL_COMMENT_2(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = SL_COMMENT_2;
		int _saveIndex;

		match("--");
		{
			_loop762: do {
				if ((_tokenSet_0.member(LA(1)))) {
					{
						match(_tokenSet_0);
					}
				} else {
					break _loop762;
				}

			} while (true);
		}
		{
			switch (LA(1)) {
			case '\n': {
				match('\n');
				break;
			}
			case '\r': {
				match('\r');
				{
					if ((LA(1) == '\n')) {
						match('\n');
					} else {
					}

				}
				break;
			}
			default: {
				throw new NoViableAltForCharException((char) LA(1),
						getFilename(), getLine(), getColumn());
			}
			}
		}
		_ttype = Token.SKIP;
		newline();
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mCOMMENT_1(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = COMMENT_1;
		int _saveIndex;

		match('{');
		{
			_loop768: do {
				if ((LA(1) == '\r') && (LA(2) == '\n')
						&& ((LA(3) >= '\u0001' && LA(3) <= '\u00ff')) && (true)) {
					match('\r');
					match('\n');
					newline();
				} else if ((LA(1) == '\r')
						&& ((LA(2) >= '\u0001' && LA(2) <= '\u00ff')) && (true)
						&& (true)) {
					match('\r');
					newline();
				} else if ((LA(1) == '\n')) {
					match('\n');
					newline();
				} else if ((_tokenSet_1.member(LA(1)))) {
					{
						match(_tokenSet_1);
					}
				} else {
					break _loop768;
				}

			} while (true);
		}
		match('}');
		_ttype = Token.SKIP;
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mIDENT(boolean _createToken) throws RecognitionException,
			CharStreamException, TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = IDENT;
		int _saveIndex;

		{
			switch (LA(1)) {
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z': {
				matchRange('a', 'z');
				break;
			}
			case '_': {
				match('_');
				break;
			}
			default: {
				throw new NoViableAltForCharException((char) LA(1),
						getFilename(), getLine(), getColumn());
			}
			}
		}
		{
			_loop772: do {
				switch (LA(1)) {
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
				case 'g':
				case 'h':
				case 'i':
				case 'j':
				case 'k':
				case 'l':
				case 'm':
				case 'n':
				case 'o':
				case 'p':
				case 'q':
				case 'r':
				case 's':
				case 't':
				case 'u':
				case 'v':
				case 'w':
				case 'x':
				case 'y':
				case 'z': {
					matchRange('a', 'z');
					break;
				}
				case '_': {
					match('_');
					break;
				}
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9': {
					matchRange('0', '9');
					break;
				}
				default: {
					break _loop772;
				}
				}
			} while (true);
		}
		_ttype = testLiteralsTable(_ttype);
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mSTRING_LITERAL(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = STRING_LITERAL;
		int _saveIndex;

		switch (LA(1)) {
		case '"': {
			{
				match('"');
			}
			{
				_loop777: do {
					if ((LA(1) == '\\')) {
						mESC(false);
					} else if ((_tokenSet_2.member(LA(1)))) {
						{
							match(_tokenSet_2);
						}
					} else {
						break _loop777;
					}

				} while (true);
			}
			{
				match('"');
			}
			break;
		}
		case '\'': {
			{
				match('\'');
			}
			{
				_loop782: do {
					if ((LA(1) == '\\')) {
						mESC(false);
					} else if ((_tokenSet_3.member(LA(1)))) {
						{
							match(_tokenSet_3);
						}
					} else {
						break _loop782;
					}

				} while (true);
			}
			{
				match('\'');
			}
			break;
		}
		default: {
			throw new NoViableAltForCharException((char) LA(1), getFilename(),
					getLine(), getColumn());
		}
		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	protected final void mESC(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = ESC;
		int _saveIndex;

		match('\\');
		{
			switch (LA(1)) {
			case 'n': {
				match('n');
				break;
			}
			case 'r': {
				match('r');
				break;
			}
			case 't': {
				match('t');
				break;
			}
			case 'b': {
				match('b');
				break;
			}
			case 'f': {
				match('f');
				break;
			}
			case '"': {
				match('"');
				break;
			}
			case '\'': {
				match('\'');
				break;
			}
			case '\\': {
				match('\\');
				break;
			}
			case 'u': {
				{
					int _cnt804 = 0;
					_loop804: do {
						if ((LA(1) == 'u')) {
							match('u');
						} else {
							if (_cnt804 >= 1) {
								break _loop804;
							} else {
								throw new NoViableAltForCharException(
										(char) LA(1), getFilename(), getLine(),
										getColumn());
							}
						}

						_cnt804++;
					} while (true);
				}
				mHEX_DIGIT(false);
				mHEX_DIGIT(false);
				mHEX_DIGIT(false);
				mHEX_DIGIT(false);
				break;
			}
			case '0':
			case '1':
			case '2':
			case '3': {
				matchRange('0', '3');
				{
					if (((LA(1) >= '0' && LA(1) <= '7'))
							&& ((LA(2) >= '\u0001' && LA(2) <= '\u00ff'))
							&& (true) && (true)) {
						matchRange('0', '7');
						{
							if (((LA(1) >= '0' && LA(1) <= '7'))
									&& ((LA(2) >= '\u0001' && LA(2) <= '\u00ff'))
									&& (true) && (true)) {
								matchRange('0', '7');
							} else if (((LA(1) >= '\u0001' && LA(1) <= '\u00ff')) && (true) && (true) && (true)) {
							} else {
								throw new NoViableAltForCharException(
										(char) LA(1), getFilename(), getLine(),
										getColumn());
							}

						}
					} else if (((LA(1) >= '\u0001' && LA(1) <= '\u00ff')) && (true) && (true) && (true)) {
					} else {
						throw new NoViableAltForCharException((char) LA(1),
								getFilename(), getLine(), getColumn());
					}

				}
				break;
			}
			case '4':
			case '5':
			case '6':
			case '7': {
				matchRange('4', '7');
				{
					if (((LA(1) >= '0' && LA(1) <= '7'))
							&& ((LA(2) >= '\u0001' && LA(2) <= '\u00ff'))
							&& (true) && (true)) {
						matchRange('0', '7');
					} else if (((LA(1) >= '\u0001' && LA(1) <= '\u00ff')) && (true) && (true) && (true)) {
					} else {
						throw new NoViableAltForCharException((char) LA(1),
								getFilename(), getLine(), getColumn());
					}

				}
				break;
			}
			default: {
				throw new NoViableAltForCharException((char) LA(1),
						getFilename(), getLine(), getColumn());
			}
			}
		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	public final void mNUM_INT(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = NUM_INT;
		int _saveIndex;
		boolean isDecimal = false;

		switch (LA(1)) {
		case '.': {
			match('.');
			_ttype = DOT;
			{
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					{
						int _cnt787 = 0;
						_loop787: do {
							if (((LA(1) >= '0' && LA(1) <= '9'))) {
								matchRange('0', '9');
							} else {
								if (_cnt787 >= 1) {
									break _loop787;
								} else {
									throw new NoViableAltForCharException(
											(char) LA(1), getFilename(),
											getLine(), getColumn());
								}
							}

							_cnt787++;
						} while (true);
					}
					_ttype = NUM_REAL;
				} else {
				}

			}
			break;
		}
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9': {
			{
				{
					matchRange('0', '9');
				}
				{
					_loop791: do {
						if (((LA(1) >= '0' && LA(1) <= '9'))) {
							matchRange('0', '9');
						} else {
							break _loop791;
						}

					} while (true);
				}
				isDecimal = true;
			}
			{
				if (((LA(1) == '.'))
						&& (LA(2) != '.' && LA(3) != '.' && isDecimal)) {
					{
						match('.');
						{
							_loop795: do {
								if (((LA(1) >= '0' && LA(1) <= '9'))) {
									matchRange('0', '9');
								} else {
									break _loop795;
								}

							} while (true);
						}
					}
					_ttype = NUM_REAL;
				} else {
				}

			}
			break;
		}
		default: {
			throw new NoViableAltForCharException((char) LA(1), getFilename(),
					getLine(), getColumn());
		}
		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	protected final void mEXPONENT(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = EXPONENT;
		int _saveIndex;

		{
			match('e');
		}
		{
			switch (LA(1)) {
			case '+': {
				match('+');
				break;
			}
			case '-': {
				match('-');
				break;
			}
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9': {
				break;
			}
			default: {
				throw new NoViableAltForCharException((char) LA(1),
						getFilename(), getLine(), getColumn());
			}
			}
		}
		{
			int _cnt800 = 0;
			_loop800: do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					matchRange('0', '9');
				} else {
					if (_cnt800 >= 1) {
						break _loop800;
					} else {
						throw new NoViableAltForCharException((char) LA(1),
								getFilename(), getLine(), getColumn());
					}
				}

				_cnt800++;
			} while (true);
		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	protected final void mHEX_DIGIT(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = HEX_DIGIT;
		int _saveIndex;

		{
			switch (LA(1)) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9': {
				matchRange('0', '9');
				break;
			}
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f': {
				matchRange('a', 'f');
				break;
			}
			default: {
				throw new NoViableAltForCharException((char) LA(1),
						getFilename(), getLine(), getColumn());
			}
			}
		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	protected final void mVOCAB(boolean _createToken)
			throws RecognitionException, CharStreamException,
			TokenStreamException {
		int _ttype;
		Token _token = null;
		int _begin = text.length();
		_ttype = VOCAB;
		int _saveIndex;

		matchRange('\1', '\377');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()
					- _begin));
		}
		_returnToken = _token;
	}

	private static final long[] mk_tokenSet_0() {
		long[] data = new long[8];
		data[0] = -9218L;
		for (int i = 1; i <= 3; i++) {
			data[i] = -1L;
		}
		return data;
	}

	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());

	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[0] = -9218L;
		data[1] = -2305843009213693953L;
		for (int i = 2; i <= 3; i++) {
			data[i] = -1L;
		}
		return data;
	}

	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());

	private static final long[] mk_tokenSet_2() {
		long[] data = new long[8];
		data[0] = -17179869186L;
		data[1] = -268435457L;
		for (int i = 2; i <= 3; i++) {
			data[i] = -1L;
		}
		return data;
	}

	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());

	private static final long[] mk_tokenSet_3() {
		long[] data = new long[8];
		data[0] = -549755813890L;
		data[1] = -268435457L;
		for (int i = 2; i <= 3; i++) {
			data[i] = -1L;
		}
		return data;
	}

	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());

}
