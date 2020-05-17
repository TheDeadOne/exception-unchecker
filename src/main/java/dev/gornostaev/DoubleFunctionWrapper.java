package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleFunction;


public class DoubleFunctionWrapper extends BaseWrapper {
    private static final MethodType DOUBLEFUNCTION_TYPE = MethodType.methodType(Object.class, double.class);

    public static <R> DoubleFunction<R> wrap(ThrowingDoubleFunction<R, ? extends Exception> doubleFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingDoubleFunction.class, DoubleFunction.class,
                DOUBLEFUNCTION_TYPE, "apply");
            return (DoubleFunction<R>) factory.invokeExact(doubleFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

