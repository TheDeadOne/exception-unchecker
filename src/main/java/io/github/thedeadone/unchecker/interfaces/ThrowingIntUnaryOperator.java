package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingIntUnaryOperator<E extends Throwable> {
    int applyAsInt(int operand) throws E;
}
