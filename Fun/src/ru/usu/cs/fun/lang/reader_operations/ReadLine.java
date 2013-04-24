package ru.usu.cs.fun.lang.reader_operations;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.UnaryOpearations;
import ru.usu.cs.fun.lang.types.FunReader;
import ru.usu.cs.fun.lang.types.FunString;

public class ReadLine extends UnaryOpearations {

	@Override
	public Term calculate(Term arg, Scope scope) {
		String s = ((FunReader) arg.eval(scope)).input.nextLine();
		return new FunString(s);
	}

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "readLine";
	}

}
