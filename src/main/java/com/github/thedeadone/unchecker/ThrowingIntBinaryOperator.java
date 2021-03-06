package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingIntBinaryOperator<E extends Exception> {
    int applyAsInt(int left, int right) throws E;
}
