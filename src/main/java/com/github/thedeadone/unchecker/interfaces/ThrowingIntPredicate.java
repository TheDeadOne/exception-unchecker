package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingIntPredicate<E extends Throwable> {
    boolean test(int value) throws E;
}
