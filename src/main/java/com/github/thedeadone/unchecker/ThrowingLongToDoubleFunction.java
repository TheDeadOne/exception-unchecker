package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingLongToDoubleFunction<E extends Exception> {
    double applyAsDouble(long value) throws E;
}
