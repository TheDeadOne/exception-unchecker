package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingDoubleToIntFunction<E extends Exception> {
    int applyAsInt(double value) throws E;
}
