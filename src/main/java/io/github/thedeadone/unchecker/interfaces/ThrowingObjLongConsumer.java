package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingObjLongConsumer<T, E extends Throwable> {
    void accept(T t, long value) throws E;
}
