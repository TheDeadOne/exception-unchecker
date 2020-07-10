package com.github.thedeadone.unchecker;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongFunction;


public class LongFunctionWrapper extends BaseWrapper {
    private static final MethodType LONGFUNCTION_TYPE = MethodType.methodType(Object.class, long.class);

    public static <R> LongFunction<R> wrap(ThrowingLongFunction<R, ? extends Exception> longFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingLongFunction.class, LongFunction.class,
                LONGFUNCTION_TYPE, "apply");
            return (LongFunction<R>) factory.invokeExact(longFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

