package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingLongPredicate<E extends Throwable> {
    boolean test(long value) throws E;
}
