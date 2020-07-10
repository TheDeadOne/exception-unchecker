package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingLongPredicate<E extends Exception> {
    boolean test(long value) throws E;
}
