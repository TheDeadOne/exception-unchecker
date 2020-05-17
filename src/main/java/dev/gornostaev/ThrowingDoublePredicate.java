package dev.gornostaev;

@FunctionalInterface
public interface ThrowingDoublePredicate<E extends Exception> {
    boolean test(double value) throws E;
}
