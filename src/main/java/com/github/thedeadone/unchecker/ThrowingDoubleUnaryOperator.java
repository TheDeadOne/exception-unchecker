package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingDoubleUnaryOperator<E extends Exception> {
    double applyAsDouble(double operand) throws E;
}
