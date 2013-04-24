package ru.usu.cs.fun.lang.reader_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.UnaryOpearations;
import ru.usu.cs.fun.lang.types.FunReader;
import ru.usu.cs.fun.lang.types.FunString;

public class OpenString extends UnaryOpearations {

	@Override
	public Term calculate(Term arg, Scope scope) {
		return new FunReader(((FunString) arg.eval(scope)).value);
	}

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "openString";
	}

}
