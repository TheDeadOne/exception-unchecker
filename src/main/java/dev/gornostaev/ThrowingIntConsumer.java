package dev.gornostaev;

@FunctionalInterface
public interface ThrowingIntConsumer<E extends Exception> {
    void accept(int value) throws E;
}
