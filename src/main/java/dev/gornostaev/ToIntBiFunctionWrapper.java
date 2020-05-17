package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToIntBiFunction;


public class ToIntBiFunctionWrapper extends BaseWrapper {
    private static final MethodType TOINTBIFUNCTION_TYPE = MethodType.methodType(int.class,
        Object.class, Object.class);

    public static <T, U> ToIntBiFunction<T, U> wrap(ThrowingToIntBiFunction<T, U, ? extends Exception> toIntBiFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingToIntBiFunction.class, ToIntBiFunction.class,
                TOINTBIFUNCTION_TYPE, "applyAsInt");
            return (ToIntBiFunction<T, U>) factory.invokeExact(toIntBiFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

