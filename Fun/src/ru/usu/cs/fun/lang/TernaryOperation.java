package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.back.TermsSubstitutor;

public abstract class TernaryOperation extends BinaryOperation {

	public Term calculate(Term arg1, Term arg2, Scope scope) {
		return new TernaryOperContinuation(arg1, arg2);
	}
	
	public abstract Term calculate (Term arg1, Term arg2, Term arg3, Scope scope);
	
	private class TernaryOperContinuation extends Term {
		private Term arg1, arg2;
		private boolean evaluated;

		public TernaryOperContinuation(Term arg1, Term arg2) {
			this.arg1 = arg1;
			this.arg2 = arg2;
		}

		@Override
		public Term apply(Term arg3, Scope scope) {
			if (!evaluated) {
				arg1 = arg1.eval(scope);
				arg2 = arg2.eval(scope);
				evaluated = true;
			}
			return calculate(arg1, arg2, arg3, scope);
		}
		
		@Override
		public String toString(TermsSubstitutor subst) {
			return TernaryOperation.this.toString() + ' '
					+ subst.substitute(arg1) + ' ' + subst.substitute(arg2);
		}
	}
}
