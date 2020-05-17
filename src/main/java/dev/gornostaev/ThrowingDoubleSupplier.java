package dev.gornostaev;

@FunctionalInterface
public interface ThrowingDoubleSupplier<E extends Exception> {
    double getAsDouble() throws E;
}
