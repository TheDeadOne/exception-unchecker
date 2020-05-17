package dev.gornostaev;

@FunctionalInterface
public interface ThrowingLongSupplier<E extends Exception> {
    long getAsLong() throws E;
}
