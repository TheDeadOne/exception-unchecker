package dev.gornostaev;

@FunctionalInterface
public interface ThrowingToLongFunction<T, E extends Exception> {
    long applyAsLong(T value) throws E;
}
