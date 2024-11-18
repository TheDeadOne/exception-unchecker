package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingBiConsumer<T, U, E extends Throwable> {
    void accept(T t, U u) throws E;
}
