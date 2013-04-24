package ru.usu.cs.fun.lang;

import java.util.HashMap;
import java.util.Map;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.number_operations.Add;
import ru.usu.cs.fun.lang.number_operations.Div;
import ru.usu.cs.fun.lang.number_operations.Eq;
import ru.usu.cs.fun.lang.number_operations.Less;
import ru.usu.cs.fun.lang.number_operations.LessOrEq;
import ru.usu.cs.fun.lang.number_operations.Mod;
import ru.usu.cs.fun.lang.number_operations.More;
import ru.usu.cs.fun.lang.number_operations.MoreOrEq;
import ru.usu.cs.fun.lang.number_operations.Mult;
import ru.usu.cs.fun.lang.number_operations.NotEq;
import ru.usu.cs.fun.lang.reader_operations.CloseReader;
import ru.usu.cs.fun.lang.reader_operations.FunConsole;
import ru.usu.cs.fun.lang.reader_operations.IsEnd;
import ru.usu.cs.fun.lang.reader_operations.OpenReader;
import ru.usu.cs.fun.lang.reader_operations.OpenString;
import ru.usu.cs.fun.lang.reader_operations.ReadInt;
import ru.usu.cs.fun.lang.reader_operations.ReadLine;
import ru.usu.cs.fun.lang.string_operations.CharAt;
import ru.usu.cs.fun.lang.string_operations.Concat;
import ru.usu.cs.fun.lang.string_operations.Insert;
import ru.usu.cs.fun.lang.string_operations.Len;
import ru.usu.cs.fun.lang.string_operations.Remove;
import ru.usu.cs.fun.lang.string_operations.Substr;
import ru.usu.cs.fun.lang.string_operations.Subtract;

public class FunScope implements Scope {

	private final Map<String, Term> items = new HashMap<String, Term>();

	public void add(String name, Term term) {
		if (find(name) != null)
			throw new RuntimeException("Symbol '" + name
					+ "' has beed already defined");
		items.put(name, term);
	}

	@Override
	public Term get(String name) {
		Term result = find(name);
		if (result == null)
			throw new RuntimeException("Symbol '" + name + "' in undefined");
		return result;
	}

	// can be null
	public Term find(String name) {
		Term result = resolveConstant(name);
		if (result != null)
			return result;
		if (name.equals("="))
			return new Eq();
		if (name.equals("!="))
			return new NotEq();
		if (name.equals("<="))
			return new LessOrEq();
		if (name.equals(">="))
			return new MoreOrEq();
		if (name.equals(">"))
			return new More();
		if (name.equals("<"))
			return new Less();
		if (name.equals("+"))
			return new Add();
		if (name.equals("-"))
			return new Subtract();
		if (name.equals("*"))
			return new Mult();
		if (name.equals("/"))
			return new Div();
		if (name.equals("%"))
			return new Mod();
		if (name.equals("print"))
			return new Print();
		if (name.equals("concat"))
			return new Concat();
		if (name.equals("len"))
			return new Len();
		if (name.equals("substr"))
			return new Substr();
		if (name.equals("charAt"))
			return new CharAt();
		if (name.equals("remove"))
			return new Remove();
		if (name.equals("insert"))
			return new Insert();
		if (name.equals("openReader"))
			return new OpenReader();
		if (name.equals("readInt"))
			return new ReadInt();
		if (name.equals("readLine"))
			return new ReadLine();
		if (name.equals("isEnd"))
			return new IsEnd();
		if (name.equals("closeReader"))
			return new CloseReader();
		if (name.equals("openString"))
			return new OpenString();
		if (name.equals("console"))
			return FunConsole.getInstance();
		return items.get(name);
	}

	private Term resolveConstant(String name) {
		return resolveBool(name);
	}

	private Term resolveBool(String name) {
		if (name.equals("true"))
			return Bool.TRUE;
		else if (name.equals("false"))
			return Bool.FALSE;
		else
			return null;
	}
}
