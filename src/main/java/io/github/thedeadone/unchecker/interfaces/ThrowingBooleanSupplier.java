package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingBooleanSupplier<E extends Throwable> {
    boolean getAsBoolean() throws E;
}
