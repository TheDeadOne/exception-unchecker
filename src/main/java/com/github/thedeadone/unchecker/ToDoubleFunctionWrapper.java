package com.github.thedeadone.unchecker;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToDoubleFunction;


public class ToDoubleFunctionWrapper extends BaseWrapper {
    private static final MethodType TODOUBLEFUNCTION_TYPE = MethodType.methodType(double.class, Object.class);

    public static <T> ToDoubleFunction<T> wrap(ThrowingToDoubleFunction<T, ? extends Exception> toDoubleFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingToDoubleFunction.class, ToDoubleFunction.class,
                TODOUBLEFUNCTION_TYPE, "applyAsDouble");
            return (ToDoubleFunction<T>) factory.invokeExact(toDoubleFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

