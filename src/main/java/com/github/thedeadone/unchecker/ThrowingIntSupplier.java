package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingIntSupplier<E extends Exception> {
    int getAsInt() throws E;
}
