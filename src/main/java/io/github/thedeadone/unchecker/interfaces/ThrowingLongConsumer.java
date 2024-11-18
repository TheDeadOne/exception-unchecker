package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingLongConsumer<E extends Throwable> {
    void accept(long value) throws E;
}
