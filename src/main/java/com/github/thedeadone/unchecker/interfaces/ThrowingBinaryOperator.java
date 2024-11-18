package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingBinaryOperator<T, E extends Throwable> {
    T apply(T left, T right) throws E;
}
