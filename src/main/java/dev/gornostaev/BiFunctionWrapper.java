package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.BiFunction;


public class BiFunctionWrapper extends BaseWrapper {
    private static final MethodType BIFUNCTION_TYPE = MethodType.methodType(Object.class, Object.class, Object.class);

    public static <T, U, R> BiFunction<T, U, R> wrap(ThrowingBiFunction<T, U, R, ? extends Exception> biFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingBiFunction.class, BiFunction.class, BIFUNCTION_TYPE, "apply");
            return (BiFunction<T, U, R>) factory.invokeExact(biFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

