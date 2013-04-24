package ru.usu.cs.fun.lang.reader_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.UnaryOpearations;
import ru.usu.cs.fun.lang.types.FunInt;
import ru.usu.cs.fun.lang.types.FunReader;

public class ReadInt extends UnaryOpearations {

	@Override
	public Term calculate(Term arg, Scope scope) {
		int v = ((FunReader) arg.eval(scope)).input.nextInt();
		return new FunInt(v);
	}

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "readInt";
	}

}
