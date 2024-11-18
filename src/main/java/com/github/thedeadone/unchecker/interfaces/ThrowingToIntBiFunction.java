package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingToIntBiFunction<T, U, E extends Throwable> {
    int applyAsInt(T t, U u) throws E;
}
