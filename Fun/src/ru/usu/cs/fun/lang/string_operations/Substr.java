package ru.usu.cs.fun.lang.string_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.TernaryOperation;
import ru.usu.cs.fun.lang.types.FunInt;
import ru.usu.cs.fun.lang.types.FunString;

public class Substr extends TernaryOperation {

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "substr";
	}

	public Term calculate(Term arg1, Term arg2, Term arg3, Scope scope) {
		String v = ((FunString) arg1).value.substring(((FunInt) arg2).value,
				((FunInt) arg3.eval(scope)).value);
		return new FunString(v);
	}
}
