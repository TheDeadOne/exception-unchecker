package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingIntFunction<R, E extends Exception> {
    R apply(int value) throws E;
}
