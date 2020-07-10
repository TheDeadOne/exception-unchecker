package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingDoubleFunction<R, E extends Exception> {
    R apply(double value) throws E;
}
