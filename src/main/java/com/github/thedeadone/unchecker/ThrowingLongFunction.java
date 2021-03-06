package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingLongFunction<R, E extends Exception> {
    R apply(long value) throws E;
}
