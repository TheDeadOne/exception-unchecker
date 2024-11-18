package com.github.thedeadone.unchecker.wrappers;

import com.github.thedeadone.unchecker.interfaces.ThrowingToDoubleBiFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToDoubleBiFunction;

public class ToDoubleBiFunctionWrapper extends BaseWrapper {
    private static final MethodType TODOUBLEBIFUNCTION_TYPE = MethodType.methodType(double.class,
        Object.class, Object.class);

    public static <T, U> ToDoubleBiFunction<T, U> wrap(ThrowingToDoubleBiFunction<T, U, ? extends Throwable> toDoubleBiFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingToDoubleBiFunction.class, ToDoubleBiFunction.class,
                TODOUBLEBIFUNCTION_TYPE, "applyAsDouble");
            return (ToDoubleBiFunction<T, U>) factory.invokeExact(toDoubleBiFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

