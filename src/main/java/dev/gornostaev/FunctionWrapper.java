package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.Function;


public class FunctionWrapper extends BaseWrapper {
    private static final MethodType FUNCTION_TYPE = MethodType.methodType(Object.class, Object.class);

    public static <T, R> Function<T, R> wrap(ThrowingFunction<T, R, ? extends Exception> function) {
        try {
            MethodHandle factory = createFactory(ThrowingFunction.class, Function.class, FUNCTION_TYPE, "apply");
            return (Function<T, R>) factory.invokeExact(function);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}
