package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingDoubleFunction<R, E extends Throwable> {
    R apply(double value) throws E;
}
