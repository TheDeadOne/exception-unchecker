package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingDoubleSupplier<E extends Throwable> {
    double getAsDouble() throws E;
}
