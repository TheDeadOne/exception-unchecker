package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingToLongBiFunction<T, U, E extends Throwable> {
    long applyAsLong(T t, U u) throws E;
}
