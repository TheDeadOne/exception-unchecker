package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingSupplier<T, E extends Throwable> {
    T get() throws E;
}
