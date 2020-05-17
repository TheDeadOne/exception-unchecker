package dev.gornostaev;

@FunctionalInterface
public interface ThrowingObjLongConsumer<T, E extends Exception> {
    void accept(T t, long value) throws E;
}
