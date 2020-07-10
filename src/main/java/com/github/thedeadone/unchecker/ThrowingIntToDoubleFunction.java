package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingIntToDoubleFunction<E extends Exception> {
    double applyAsDouble(int value) throws E;
}
