package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingToIntFunction<T, E extends Exception> {
    int applyAsInt(T value) throws E;
}
