package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingToLongBiFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ToLongBiFunction;

public class ToLongBiFunctionWrapper extends BaseWrapper {
    private static final MethodType TOLONGBIFUNCTION_TYPE = MethodType.methodType(long.class,
        Object.class, Object.class);

    public static <T, U> ToLongBiFunction<T, U> wrap(ThrowingToLongBiFunction<T, U, ? extends Throwable> toLongBiFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingToLongBiFunction.class, ToLongBiFunction.class,
                TOLONGBIFUNCTION_TYPE, "applyAsLong");
            return (ToLongBiFunction<T, U>) factory.invokeExact(toLongBiFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

