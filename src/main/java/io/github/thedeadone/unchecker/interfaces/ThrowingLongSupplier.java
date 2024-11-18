package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingLongSupplier<E extends Throwable> {
    long getAsLong() throws E;
}
