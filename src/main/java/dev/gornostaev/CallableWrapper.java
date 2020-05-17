package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.concurrent.Callable;


public class CallableWrapper extends BaseWrapper {
    private static final MethodType CALLABLE_TYPE = MethodType.methodType(Object.class);

    public static <V> Callable<V> wrap(ThrowingCallable<V, ? extends Exception> callable) {
        try {
            MethodHandle factory = createFactory(ThrowingCallable.class, Callable.class, CALLABLE_TYPE, "call");
            return (Callable<V>) factory.invokeExact(callable);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}
