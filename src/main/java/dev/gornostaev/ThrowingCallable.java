package dev.gornostaev;

@FunctionalInterface
public interface ThrowingCallable<V, E extends Exception> {
    V call() throws E;
}
