package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingToDoubleBiFunction<T, U, E extends Throwable> {
    double applyAsDouble(T t, U u) throws E;
}
