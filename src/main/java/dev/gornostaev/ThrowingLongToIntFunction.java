package dev.gornostaev;

@FunctionalInterface
public interface ThrowingLongToIntFunction<E extends Exception> {
    int applyAsInt(long value) throws E;
}
