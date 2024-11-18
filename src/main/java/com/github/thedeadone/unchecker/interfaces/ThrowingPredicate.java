package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingPredicate<T, E extends Throwable> {
    boolean test(T t) throws E;
}
