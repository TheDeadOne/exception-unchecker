package dev.gornostaev;

@FunctionalInterface
public interface ThrowingToIntFunction<T, E extends Exception> {
    int applyAsInt(T value) throws E;
}
