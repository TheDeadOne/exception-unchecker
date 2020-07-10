package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingDoubleBinaryOperator<E extends Exception> {
    double applyAsDouble(double left, double right) throws E;
}
