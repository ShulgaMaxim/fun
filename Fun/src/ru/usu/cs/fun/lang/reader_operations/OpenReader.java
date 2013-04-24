package ru.usu.cs.fun.lang.reader_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.BinaryOperation;
import ru.usu.cs.fun.lang.types.FunReader;
import ru.usu.cs.fun.lang.types.FunString;

public class OpenReader extends BinaryOperation {

	@Override
	public Term calculate(Term arg1, Term arg2, Scope scope) {
		return new FunReader(((FunString) arg1).value,
				((FunString) arg2.eval(scope)).value);
	}

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "openReader";
	}

}
