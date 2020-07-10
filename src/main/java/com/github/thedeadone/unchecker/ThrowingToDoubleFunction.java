package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingToDoubleFunction<T, E extends Exception> {
    double applyAsDouble(T value) throws E;
}
