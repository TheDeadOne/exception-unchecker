package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleToLongFunction;


public class DoubleToLongFunctionWrapper extends BaseWrapper {
    private static final MethodType DOUBLETOLONGFUNCTION_TYPE = MethodType.methodType(long.class, double.class);

    public static DoubleToLongFunction wrap(ThrowingDoubleToLongFunction<? extends Exception> doubleToLongFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingDoubleToLongFunction.class, DoubleToLongFunction.class,
                DOUBLETOLONGFUNCTION_TYPE, "applyAsLong");
            return (DoubleToLongFunction) factory.invokeExact(doubleToLongFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

