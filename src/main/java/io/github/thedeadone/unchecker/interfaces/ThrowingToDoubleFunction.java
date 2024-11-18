package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingToDoubleFunction<T, E extends Throwable> {
    double applyAsDouble(T value) throws E;
}
