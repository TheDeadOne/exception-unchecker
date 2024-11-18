package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingDoubleToLongFunction<E extends Throwable> {
    long applyAsLong(double value) throws E;
}
