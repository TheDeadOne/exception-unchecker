package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingIntUnaryOperator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntUnaryOperator;

public class IntUnaryOperatorWrapper extends BaseWrapper {
    private static final MethodType INTUNARYOPERATOR_TYPE = MethodType.methodType(int.class, int.class);

    public static IntUnaryOperator wrap(ThrowingIntUnaryOperator<? extends Throwable> intUnaryOperator) {
        try {
            MethodHandle factory = createFactory(ThrowingIntUnaryOperator.class, IntUnaryOperator.class,
                INTUNARYOPERATOR_TYPE, "applyAsInt");
            return (IntUnaryOperator) factory.invokeExact(intUnaryOperator);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

