package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongBinaryOperator;


public class LongBinaryOperatorWrapper extends BaseWrapper {
    private static final MethodType LONGBINARYOPERATOR_TYPE = MethodType.methodType(long.class, long.class, long.class);

    public static LongBinaryOperator wrap(ThrowingLongBinaryOperator<? extends Exception> longBinaryOperator) {
        try {
            MethodHandle factory = createFactory(ThrowingLongBinaryOperator.class, LongBinaryOperator.class,
                LONGBINARYOPERATOR_TYPE, "applyAsLong");
            return (LongBinaryOperator) factory.invokeExact(longBinaryOperator);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

