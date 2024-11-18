package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingLongUnaryOperator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongUnaryOperator;

public class LongUnaryOperatorWrapper extends BaseWrapper {
    private static final MethodType LONGUNARYOPERATOR_TYPE = MethodType.methodType(long.class, long.class);

    public static LongUnaryOperator wrap(ThrowingLongUnaryOperator<? extends Throwable> longUnaryOperator) {
        try {
            MethodHandle factory = createFactory(ThrowingLongUnaryOperator.class, LongUnaryOperator.class,
                LONGUNARYOPERATOR_TYPE, "applyAsLong");
            return (LongUnaryOperator) factory.invokeExact(longUnaryOperator);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

