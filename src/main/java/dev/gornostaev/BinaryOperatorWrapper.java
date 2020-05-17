package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.BinaryOperator;


public class BinaryOperatorWrapper extends BaseWrapper {
    private static final MethodType BINARYOPERATOR_TYPE = MethodType.methodType(Object.class,
        Object.class, Object.class);

    public static <T> BinaryOperator<T> wrap(ThrowingBinaryOperator<T, ? extends Exception> binaryOperator) {
        try {
            MethodHandle factory = createFactory(ThrowingBinaryOperator.class, BinaryOperator.class,
                BINARYOPERATOR_TYPE, "apply");
            return (BinaryOperator<T>) factory.invokeExact(binaryOperator);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

