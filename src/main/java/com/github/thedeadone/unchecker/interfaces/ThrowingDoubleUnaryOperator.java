package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingDoubleUnaryOperator<E extends Throwable> {
    double applyAsDouble(double operand) throws E;
}
