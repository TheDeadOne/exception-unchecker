package com.github.thedeadone.unchecker.wrappers;

import com.github.thedeadone.unchecker.interfaces.ThrowingToIntFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToIntFunction;

public class ToIntFunctionWrapper extends BaseWrapper {
    private static final MethodType TOINTFUNCTION_TYPE = MethodType.methodType(int.class, Object.class);

    public static <T> ToIntFunction<T> wrap(ThrowingToIntFunction<T, ? extends Throwable> toIntFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingToIntFunction.class, ToIntFunction.class,
                TOINTFUNCTION_TYPE, "applyAsInt");
            return (ToIntFunction<T>) factory.invokeExact(toIntFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

