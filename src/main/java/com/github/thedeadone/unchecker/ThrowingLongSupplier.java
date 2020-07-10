package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingLongSupplier<E extends Exception> {
    long getAsLong() throws E;
}
