package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingDoubleToIntFunction<E extends Throwable> {
    int applyAsInt(double value) throws E;
}
