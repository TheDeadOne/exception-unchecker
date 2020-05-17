package dev.gornostaev;

@FunctionalInterface
public interface ThrowingDoubleToIntFunction<E extends Exception> {
    int applyAsInt(double value) throws E;
}
