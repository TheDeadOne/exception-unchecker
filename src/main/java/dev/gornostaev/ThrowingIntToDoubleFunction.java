package dev.gornostaev;

@FunctionalInterface
public interface ThrowingIntToDoubleFunction<E extends Exception> {
    double applyAsDouble(int value) throws E;
}
