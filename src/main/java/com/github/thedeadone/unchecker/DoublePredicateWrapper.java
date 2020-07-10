package com.github.thedeadone.unchecker;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoublePredicate;


public class DoublePredicateWrapper extends BaseWrapper {
    private static final MethodType DOUBLEPREDICATE_TYPE = MethodType.methodType(boolean.class, double.class);

    public static DoublePredicate wrap(ThrowingDoublePredicate<? extends Exception> doublePredicate) {
        try {
            MethodHandle factory = createFactory(ThrowingDoublePredicate.class, DoublePredicate.class,
                DOUBLEPREDICATE_TYPE, "test");
            return (DoublePredicate) factory.invokeExact(doublePredicate);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

