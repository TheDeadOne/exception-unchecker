package dev.gornostaev;

@FunctionalInterface
public interface ThrowingLongUnaryOperator<E extends Exception> {
    long applyAsLong(long operand) throws E;
}
