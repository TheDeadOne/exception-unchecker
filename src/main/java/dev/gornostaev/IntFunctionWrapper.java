package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntFunction;


public class IntFunctionWrapper extends BaseWrapper {
    private static final MethodType INTFUNCTION_TYPE = MethodType.methodType(Object.class, int.class);

    public static <R> IntFunction<R> wrap(ThrowingIntFunction<R, ? extends Exception> intFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingIntFunction.class, IntFunction.class,
                INTFUNCTION_TYPE, "apply");
            return (IntFunction<R>) factory.invokeExact(intFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

