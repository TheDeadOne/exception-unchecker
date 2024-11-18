package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingLongToDoubleFunction<E extends Throwable> {
    double applyAsDouble(long value) throws E;
}
