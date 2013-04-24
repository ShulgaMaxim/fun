package ru.usu.cs.fun.lang.string_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.TernaryOperation;
import ru.usu.cs.fun.lang.types.FunInt;
import ru.usu.cs.fun.lang.types.FunString;

public class Remove extends TernaryOperation {

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "remove";
	}

	public Term calculate(Term arg1, Term arg2, Term arg3, Scope scope) {
		String str = ((FunString) arg1).value;
		int ind1 = (Integer) ((FunInt) arg2).value;
		int ind2 = (Integer) ((FunInt) arg3.eval(scope)).value;
		String s1 = str.substring(0, ind1);
		String s2 = str.substring(ind2);
		return new FunString(s1.concat(s2));
	}
}
