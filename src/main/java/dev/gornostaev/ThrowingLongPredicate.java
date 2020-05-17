package dev.gornostaev;

@FunctionalInterface
public interface ThrowingLongPredicate<E extends Exception> {
    boolean test(long value) throws E;
}
