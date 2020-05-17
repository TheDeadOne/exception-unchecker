package dev.gornostaev;

@FunctionalInterface
public interface ThrowingDoubleFunction<R, E extends Exception> {
    R apply(double value) throws E;
}
