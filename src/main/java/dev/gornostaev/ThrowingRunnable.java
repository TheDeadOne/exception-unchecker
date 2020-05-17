package dev.gornostaev;

@FunctionalInterface
public interface ThrowingRunnable<E extends Exception> {
    void run() throws E;
}
