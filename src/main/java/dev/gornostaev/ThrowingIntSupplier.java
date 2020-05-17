package dev.gornostaev;

@FunctionalInterface
public interface ThrowingIntSupplier<E extends Exception> {
    int getAsInt() throws E;
}
