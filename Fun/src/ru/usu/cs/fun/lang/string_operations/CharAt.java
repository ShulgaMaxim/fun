package ru.usu.cs.fun.lang.string_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.BinaryOperation;
import ru.usu.cs.fun.lang.types.FunInt;
import ru.usu.cs.fun.lang.types.FunString;

public class CharAt extends BinaryOperation {

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "charAt";
	}

	public Term calculate(Term arg1, Term arg2, Scope scope) {
		int v = ((FunString)arg1).value.charAt((Integer) ((FunInt) arg2.eval(scope)).value);
		return new FunInt(v);
	}

}
