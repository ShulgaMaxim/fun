package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;

public  abstract class UnaryOpearations extends Term {
	
	public abstract Term calculate(Term arg, Scope scope);
	
	@Override
	public Term apply(Term arg, Scope scope) {
		return calculate(arg, scope);
	}

}
