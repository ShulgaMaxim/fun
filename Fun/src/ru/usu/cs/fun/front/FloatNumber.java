package ru.usu.cs.fun.front;

public class FloatNumber extends AutomatonRecognizer {
	
	public FloatNumber() {
		super("float");
		transition(INITIAL_STATE, "sign", "sign");
		transition("sign", "digits", "number");
		transition("number", "digits", "number");
		transition(INITIAL_STATE, "digits", "number");
		transition("number", "point", "point");
		transition("point", "digits", "number");
		transition("number", "exp", "exp");
		transition("exp", "sign", "sign");
		transition("exp", "digits", "number");
		finalStates("number", "point");
	}

	@Override
	protected String getCharClass(char ch) {
		if ('0' <= ch && ch <= '9')
			return "digits";
		if (ch == '+' || ch == '-')
			return "sign";
		if (ch == '.')
			return "point";
		if (ch == 'e' || ch == 'E')
			return "exp";
		return "#";
	}

	@Override
	protected Float getValue(String text) {
		return Float.parseFloat(text);
	}
}
