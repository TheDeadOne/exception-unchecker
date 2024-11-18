package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingIntFunction<R, E extends Throwable> {
    R apply(int value) throws E;
}
