package dev.gornostaev;

@FunctionalInterface
public interface ThrowingBooleanSupplier<E extends Exception> {
    boolean getAsBoolean() throws E;
}
