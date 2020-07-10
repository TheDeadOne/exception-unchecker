package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingBooleanSupplier<E extends Exception> {
    boolean getAsBoolean() throws E;
}
