package ru.usu.cs.fun.lang.types;

import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public abstract class Value<Type> extends Term {

	
	public final Type value;
	
	public Value(Type value) {
		super();
		this.value = value;
	}
	
	@Override
	public String toString(TermsSubstitutor subst) {
		return value + "";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof FunString) 
			return value.equals(obj.toString());
		if (obj instanceof FunInt) 
			return value == ((FunInt) obj).value;
		if (obj instanceof FunFloat) 
			return value == ((FunFloat) obj).value;

		return false;
	}

	@Override
	public Term substitute(String name, Term value) {
		return this;
	}
	
	@Override
	public int hashCode() {
		if (value instanceof Integer)
			return (Integer) value;
		return value.hashCode();
	}
	
}
