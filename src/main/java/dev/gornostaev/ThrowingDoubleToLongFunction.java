package dev.gornostaev;

@FunctionalInterface
public interface ThrowingDoubleToLongFunction<E extends Exception> {
    long applyAsLong(double value) throws E;
}
