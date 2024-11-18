package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingToLongFunction<T, E extends Throwable> {
    long applyAsLong(T value) throws E;
}
