package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingCallable<V, E extends Throwable> {
    V call() throws E;
}
