package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingIntBinaryOperator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntBinaryOperator;

public class IntBinaryOperatorWrapper extends BaseWrapper {
    private static final MethodType INTBINARYOPERATOR_TYPE = MethodType.methodType(int.class, int.class, int.class);

    public static IntBinaryOperator wrap(ThrowingIntBinaryOperator<? extends Throwable> intBinaryOperator) {
        try {
            MethodHandle factory = createFactory(ThrowingIntBinaryOperator.class, IntBinaryOperator.class,
                INTBINARYOPERATOR_TYPE, "applyAsInt");
            return (IntBinaryOperator) factory.invokeExact(intBinaryOperator);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

