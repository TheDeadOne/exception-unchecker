package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingUnaryOperator;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.UnaryOperator;

public class UnaryOperatorWrapper extends BaseWrapper {
    private static final MethodType UNARYOPERATOR_TYPE = MethodType.methodType(Object.class, Object.class);

    public static <T> UnaryOperator<T> wrap(ThrowingUnaryOperator<T, ? extends Throwable> unaryOperator) {
        try {
            MethodHandle factory = createFactory(ThrowingUnaryOperator.class, UnaryOperator.class,
                UNARYOPERATOR_TYPE, "apply");
            return (UnaryOperator<T>) factory.invokeExact(unaryOperator);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

