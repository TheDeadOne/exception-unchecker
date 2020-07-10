package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingPredicate<T, E extends Exception> {
    boolean test(T t) throws E;
}
