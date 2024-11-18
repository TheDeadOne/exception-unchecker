package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingPredicate;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.Predicate;

public class PredicateWrapper extends BaseWrapper {
    private static final MethodType PREDICATE_TYPE = MethodType.methodType(boolean.class, Object.class);

    public static <T> Predicate<T> wrap(ThrowingPredicate<T, ? extends Throwable> predicate) {
        try {
            MethodHandle factory = createFactory(ThrowingPredicate.class, Predicate.class, PREDICATE_TYPE, "test");
            return (Predicate<T>) factory.invokeExact(predicate);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}
