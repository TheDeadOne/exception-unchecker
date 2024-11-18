package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingRunnable<E extends Throwable> {
    void run() throws E;
}
