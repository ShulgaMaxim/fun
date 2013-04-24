package ru.usu.cs.fun.lang;

import ru.usu.cs.fun.back.Scope;
import ru.usu.cs.fun.back.Term;
import ru.usu.cs.fun.lang.types.FunFloat;
import ru.usu.cs.fun.lang.types.FunInt;

public abstract class Arithmetic extends BinaryOperation {

	public Term calculate(Term arg1, Term arg2, Scope scope) {
		int flag = 0;
		arg2 = arg2.eval(scope);
		if (arg1 instanceof FunFloat)
			flag += 1;
		if (arg2 instanceof FunFloat)
			flag += 2;

		if (flag == 1)
			return action(((FunFloat) arg1).value, ((FunInt) arg2).value * 1.0f);
		else if (flag == 0)
			return action(((FunInt) arg1).value, ((FunInt) arg2).value);
		else if (flag == 2)
			return action(((FunInt) arg1).value * 1.0f, ((FunFloat) arg2).value);
		else if (flag == 3)
			return action(((FunFloat) arg1).value, ((FunFloat) arg2).value);
		return null;

	}

	protected abstract Term action(int v1, int v2);

	protected abstract Term action(float v1, float v2);
}
