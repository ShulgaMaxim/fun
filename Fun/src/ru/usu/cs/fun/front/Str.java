package ru.usu.cs.fun.front;


public class Str extends AutomatonRecognizer {

	public Str() {
		super("string");
		transition(INITIAL_STATE, "quote", "abc");
		transition("abc", "abc");
		transition("abc", "bSlash", "bSlash");
		transition("bSlash", "abc");
		transition("abc", "quote", "quote");
		finalStates("quote");

	}

	@Override
	protected String getCharClass(char ch) {
		boolean backSlash = (ch == '\\');
		boolean quote = (ch == '\"');
		if (backSlash)
			return "bSlash";
		else if (quote)
			return "quote";
		return "*";
	}

	@Override
	protected String getValue(String text) {
		text = text.substring(1, text.length() - 1);
		StringBuffer symb = new StringBuffer(text);
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < symb.length(); i++) {
			if (symb.charAt(i) == '\\') {
				if (symb.charAt(i + 1) == 'n')
					result.append('\n');
				else if (symb.charAt(i + 1) == 'r')
					result.append('\r');
				else if (symb.charAt(i + 1) == 't')
					result.append('\t');
				else
					result.append(symb.charAt(i + 1));
				i++;
			} else
				result.append(symb.charAt(i));
		}
		return new String(result);
	}
}
