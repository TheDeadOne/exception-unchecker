package dev.gornostaev;

@FunctionalInterface
public interface ThrowingToIntBiFunction<T, U, E extends Exception> {
    int applyAsInt(T t, U u) throws E;
}
