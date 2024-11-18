package io.github.thedeadone.unchecker.interfaces;

@FunctionalInterface
public interface ThrowingUnaryOperator<T, E extends Throwable> {
    T apply(T t) throws E;
}
