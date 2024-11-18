package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingDoubleBinaryOperator<E extends Throwable> {
    double applyAsDouble(double left, double right) throws E;
}
