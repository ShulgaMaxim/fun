package ru.usu.cs.fun.lang.reader_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.Bool;
import ru.usu.cs.fun.lang.UnaryOpearations;
import ru.usu.cs.fun.lang.types.FunReader;

public class IsEnd extends UnaryOpearations {

	@Override
	public Term calculate(Term arg, Scope scope) {
		boolean b = ((FunReader) arg.eval(scope)).input.hasNext();
		return b ? Bool.FALSE : Bool.TRUE;
	}

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "isEnd";
	}

}
