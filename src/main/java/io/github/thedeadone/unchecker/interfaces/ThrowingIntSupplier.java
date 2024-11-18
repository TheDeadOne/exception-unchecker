package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingIntSupplier<E extends Throwable> {
    int getAsInt() throws E;
}
