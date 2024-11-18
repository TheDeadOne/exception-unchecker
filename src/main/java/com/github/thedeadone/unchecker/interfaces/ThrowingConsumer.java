package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingConsumer<T, E extends Throwable> {
    void accept(T t) throws E;
}
