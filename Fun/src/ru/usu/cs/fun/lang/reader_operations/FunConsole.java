package ru.usu.cs.fun.lang.reader_operations;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;
import ru.usu.cs.fun.lang.types.FunReader;


public class FunConsole extends Term {

	@Override
	public String toString(TermsSubstitutor substitutor) {
		return "console";
	}
	
	private static class FunReaderHolder {
		private final static FunReader instance = new FunReader();
	}
	
	public static FunReader getInstance() {
		return FunReaderHolder.instance;		
	}
	
}
