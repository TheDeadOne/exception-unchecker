package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingIntConsumer<E extends Throwable> {
    void accept(int value) throws E;
}
