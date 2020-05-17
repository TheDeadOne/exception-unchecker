package dev.gornostaev;

@FunctionalInterface
public interface ThrowingUnaryOperator<T, E extends Exception> {
    T apply(T t) throws E;
}
