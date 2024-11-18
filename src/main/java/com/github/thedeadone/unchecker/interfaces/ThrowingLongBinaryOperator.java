package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingLongBinaryOperator<E extends Throwable> {
    long applyAsLong(long left, long right) throws E;
}
