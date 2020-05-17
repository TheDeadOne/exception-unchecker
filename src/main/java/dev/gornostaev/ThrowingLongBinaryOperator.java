package dev.gornostaev;

@FunctionalInterface
public interface ThrowingLongBinaryOperator<E extends Exception> {
    long applyAsLong(long left, long right) throws E;
}
