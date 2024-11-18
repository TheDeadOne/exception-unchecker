package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingObjDoubleConsumer<T, E extends Throwable> {
    void accept(T t, double value) throws E;
}
