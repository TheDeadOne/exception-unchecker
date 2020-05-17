package dev.gornostaev;

@FunctionalInterface
public interface ThrowingBiPredicate<T, U, E extends Exception> {
    boolean test(T t, U u) throws E;
}
