package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingLongToIntFunction<E extends Exception> {
    int applyAsInt(long value) throws E;
}
