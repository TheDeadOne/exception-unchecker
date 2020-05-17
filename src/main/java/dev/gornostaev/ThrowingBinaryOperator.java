package dev.gornostaev;

@FunctionalInterface
public interface ThrowingBinaryOperator<T, E extends Exception> {
    T apply(T left, T right) throws E;
}
