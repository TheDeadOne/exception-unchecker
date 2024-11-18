package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingIntToLongFunction<E extends Throwable> {
    long applyAsLong(int value) throws E;
}
