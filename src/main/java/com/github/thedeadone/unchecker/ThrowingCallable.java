package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingCallable<V, E extends Exception> {
    V call() throws E;
}
