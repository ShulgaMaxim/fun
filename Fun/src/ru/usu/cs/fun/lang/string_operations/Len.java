package ru.usu.cs.fun.lang.string_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.UnaryOpearations;
import ru.usu.cs.fun.lang.types.FunInt;
import ru.usu.cs.fun.lang.types.FunString;

public class Len extends UnaryOpearations {

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "len";
	}

	public Term calculate(Term arg, Scope scope) {
		return new FunInt(((FunString) arg.eval(scope)).value.length());
	}

}
