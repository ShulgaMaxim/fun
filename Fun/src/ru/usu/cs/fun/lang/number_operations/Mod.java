package ru.usu.cs.fun.lang.number_operations;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.Arithmetic;
import ru.usu.cs.fun.lang.types.FunInt;

public class Mod extends Arithmetic {

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "%";
	}

	protected Term action(int firstValue, int secondValue) {
		return new FunInt(firstValue % secondValue);
	}

	protected Term action(float firstValue, float secondValue) {
		return null;
	}
}