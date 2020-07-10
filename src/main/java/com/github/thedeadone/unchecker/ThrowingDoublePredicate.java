package com.github.thedeadone.unchecker;

@FunctionalInterface
public interface ThrowingDoublePredicate<E extends Exception> {
    boolean test(double value) throws E;
}
