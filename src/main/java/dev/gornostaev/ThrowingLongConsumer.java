package dev.gornostaev;

@FunctionalInterface
public interface ThrowingLongConsumer<E extends Exception> {
    void accept(long value) throws E;
}
