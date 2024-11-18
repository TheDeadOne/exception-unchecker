package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingLongFunction<R, E extends Throwable> {
    R apply(long value) throws E;
}
