package ru.usu.cs.fun.lang.string_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.TernaryOperation;
import ru.usu.cs.fun.lang.types.FunInt;
import ru.usu.cs.fun.lang.types.FunString;

public class Insert extends TernaryOperation {

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "insert";
	}

	public Term calculate(Term arg1, Term arg2, Term arg3, Scope scope) {
		String str1 = ((FunString) arg1).value;
		String str2 = ((FunString) arg2).value;
		int ind = ((FunInt) arg3.eval(scope)).value;
		String s1 = (str1.substring(0, ind)).concat(str2);
		String s2 = str1.substring(ind);
		return new FunString(s1.concat(s2));
	}
}
