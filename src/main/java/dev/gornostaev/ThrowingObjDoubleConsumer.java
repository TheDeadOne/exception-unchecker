package dev.gornostaev;

@FunctionalInterface
public interface ThrowingObjDoubleConsumer<T, E extends Exception> {
    void accept(T t, double value) throws E;
}
