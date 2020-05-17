package dev.gornostaev;

@FunctionalInterface
public interface ThrowingDoubleConsumer<E extends Exception> {
    void accept(double value) throws E;
}
