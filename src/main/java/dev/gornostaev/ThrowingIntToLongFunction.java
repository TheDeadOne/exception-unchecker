package dev.gornostaev;

@FunctionalInterface
public interface ThrowingIntToLongFunction<E extends Exception> {
    long applyAsLong(int value) throws E;
}
