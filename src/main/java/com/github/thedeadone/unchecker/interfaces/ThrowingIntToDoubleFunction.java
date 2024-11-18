package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingIntToDoubleFunction<E extends Throwable> {
    double applyAsDouble(int value) throws E;
}
