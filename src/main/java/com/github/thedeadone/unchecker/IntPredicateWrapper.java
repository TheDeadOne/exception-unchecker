package com.github.thedeadone.unchecker;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntPredicate;


public class IntPredicateWrapper extends BaseWrapper {
    private static final MethodType INTPREDICATE_TYPE = MethodType.methodType(boolean.class, int.class);

    public static IntPredicate wrap(ThrowingIntPredicate<? extends Exception> intPredicate) {
        try {
            MethodHandle factory = createFactory(ThrowingIntPredicate.class, IntPredicate.class,
                INTPREDICATE_TYPE, "test");
            return (IntPredicate) factory.invokeExact(intPredicate);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

