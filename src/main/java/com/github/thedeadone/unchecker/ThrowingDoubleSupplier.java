package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingDoubleSupplier<E extends Exception> {
    double getAsDouble() throws E;
}
