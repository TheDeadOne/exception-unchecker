package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingDoubleConsumer<E extends Throwable> {
    void accept(double value) throws E;
}
