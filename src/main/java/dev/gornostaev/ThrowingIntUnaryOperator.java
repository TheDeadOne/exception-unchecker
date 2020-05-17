package dev.gornostaev;

@FunctionalInterface
public interface ThrowingIntUnaryOperator<E extends Exception> {
    int applyAsInt(int operand) throws E;
}
