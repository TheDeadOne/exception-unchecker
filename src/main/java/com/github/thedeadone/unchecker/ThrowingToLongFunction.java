package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingToLongFunction<T, E extends Exception> {
    long applyAsLong(T value) throws E;
}
