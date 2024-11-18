package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingBiFunction<T, U, R, E extends Throwable> {
    R apply(T t, U u) throws E;
}
