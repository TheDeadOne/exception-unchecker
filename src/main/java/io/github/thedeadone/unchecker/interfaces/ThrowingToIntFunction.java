package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingToIntFunction<T, E extends Throwable> {
    int applyAsInt(T value) throws E;
}
