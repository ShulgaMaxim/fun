package ru.usu.cs.fun.lang.string_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.BinaryOperation;
import ru.usu.cs.fun.lang.types.FunString;

public class Concat extends BinaryOperation {
	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "concat";
	}

	public Term calculate(Term firstValue, Term secondValue, Scope scope) {
		String v = ((FunString) firstValue).value
				.concat(((FunString) secondValue.eval(scope)).value);
		return new FunString(v);
	}

}
