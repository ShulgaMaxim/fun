package ru.usu.cs.fun.lang.reader_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.Bool;
import ru.usu.cs.fun.lang.UnaryOpearations;
import ru.usu.cs.fun.lang.types.FunReader;

public class CloseReader extends UnaryOpearations {

	@Override
	public Term calculate(Term arg, Scope scope) {
		((FunReader) arg.eval(scope)).input.close();
		return Bool.TRUE;
	}

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "closeReader";
	}

}
