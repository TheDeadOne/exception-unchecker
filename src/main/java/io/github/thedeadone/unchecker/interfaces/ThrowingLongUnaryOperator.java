package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingLongUnaryOperator<E extends Throwable> {
    long applyAsLong(long operand) throws E;
}
