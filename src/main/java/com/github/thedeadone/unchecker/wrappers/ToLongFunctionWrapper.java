package com.github.thedeadone.unchecker.wrappers;

import com.github.thedeadone.unchecker.interfaces.ThrowingToLongFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToLongFunction;

public class ToLongFunctionWrapper extends BaseWrapper {
    private static final MethodType TOLONGFUNCTION_TYPE = MethodType.methodType(long.class, Object.class);

    public static <T> ToLongFunction<T> wrap(ThrowingToLongFunction<T, ? extends Throwable> toLongFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingToLongFunction.class, ToLongFunction.class,
                TOLONGFUNCTION_TYPE, "applyAsLong");
            return (ToLongFunction<T>) factory.invokeExact(toLongFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

