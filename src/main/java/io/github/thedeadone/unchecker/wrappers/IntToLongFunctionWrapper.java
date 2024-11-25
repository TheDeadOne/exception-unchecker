package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingIntToLongFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntToLongFunction;

public class IntToLongFunctionWrapper extends BaseWrapper {
    private static final MethodType INTTOLONGFUNCTION_TYPE = MethodType.methodType(long.class, int.class);

    public static IntToLongFunction wrap(ThrowingIntToLongFunction<? extends Throwable> intToLongFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingIntToLongFunction.class, IntToLongFunction.class,
                INTTOLONGFUNCTION_TYPE, "applyAsLong");
            return (IntToLongFunction) factory.invokeExact(intToLongFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

