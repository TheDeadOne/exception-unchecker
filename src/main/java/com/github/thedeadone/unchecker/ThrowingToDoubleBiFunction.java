package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingToDoubleBiFunction<T, U, E extends Exception> {
    double applyAsDouble(T t, U u) throws E;
}
