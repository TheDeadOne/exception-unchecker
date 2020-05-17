package dev.gornostaev;

@FunctionalInterface
public interface ThrowingIntPredicate<E extends Exception> {
    boolean test(int value) throws E;
}
