package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingToLongBiFunction<T, U, E extends Exception> {
    long applyAsLong(T t, U u) throws E;
}
