package dev.gornostaev;

@FunctionalInterface
public interface ThrowingObjIntConsumer<T, E extends Exception> {
    void accept(T t, int value) throws E;
}
