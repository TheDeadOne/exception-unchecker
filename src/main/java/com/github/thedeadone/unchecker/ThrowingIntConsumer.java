package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingIntConsumer<E extends Exception> {
    void accept(int value) throws E;
}
