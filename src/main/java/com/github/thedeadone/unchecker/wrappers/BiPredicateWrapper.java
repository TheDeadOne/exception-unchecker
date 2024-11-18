package com.github.thedeadone.unchecker.wrappers;

import com.github.thedeadone.unchecker.interfaces.ThrowingBiPredicate;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.BiPredicate;

public class BiPredicateWrapper extends BaseWrapper {
    private static final MethodType BIPREDICATE_TYPE = MethodType.methodType(boolean.class, Object.class, Object.class);

    public static <T, U> BiPredicate<T, U> wrap(ThrowingBiPredicate<T, U, ? extends Throwable> biPredicate) {
        try {
            MethodHandle factory = createFactory(ThrowingBiPredicate.class, BiPredicate.class,
                BIPREDICATE_TYPE, "test");
            return (BiPredicate<T, U>) factory.invokeExact(biPredicate);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

