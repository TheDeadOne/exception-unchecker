package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingDoubleToLongFunction<E extends Exception> {
    long applyAsLong(double value) throws E;
}
