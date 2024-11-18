package com.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingDoublePredicate<E extends Throwable> {
    boolean test(double value) throws E;
}
