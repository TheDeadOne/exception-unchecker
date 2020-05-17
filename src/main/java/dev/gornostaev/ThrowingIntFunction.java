package dev.gornostaev;

@FunctionalInterface
public interface ThrowingIntFunction<R, E extends Exception> {
    R apply(int value) throws E;
}
