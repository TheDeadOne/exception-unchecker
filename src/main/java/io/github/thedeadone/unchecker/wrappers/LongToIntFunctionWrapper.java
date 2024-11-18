package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingLongToIntFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongToIntFunction;

public class LongToIntFunctionWrapper extends BaseWrapper {
    private static final MethodType LONGTOINTFUNCTION_TYPE = MethodType.methodType(int.class, long.class);

    public static LongToIntFunction wrap(ThrowingLongToIntFunction<? extends Throwable> longToIntFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingLongToIntFunction.class, LongToIntFunction.class,
                LONGTOINTFUNCTION_TYPE, "applyAsInt");
            return (LongToIntFunction) factory.invokeExact(longToIntFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

