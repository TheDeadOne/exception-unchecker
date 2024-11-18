package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingObjIntConsumer<T, E extends Throwable> {
    void accept(T t, int value) throws E;
}
