package com.github.thedeadone.unchecker;

import com.github.thedeadone.unchecker.interfaces.*;
import com.github.thedeadone.unchecker.wrappers.*;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Helper for frequently used wrappers
 */
public final class Helper {
    private Helper() {  }

    public static Runnable uncheck(ThrowingRunnable<? extends Throwable> runnable) {
        return RunnableWrapper.wrap(runnable);
    }

    public static <T> Consumer<T> uncheck(ThrowingConsumer<T, ? extends Throwable> consumer) {
        return ConsumerWrapper.wrap(consumer);
    }

    public static <T, R> Function<T, R> uncheck(ThrowingFunction<T, R, ? extends Throwable> function) {
        return FunctionWrapper.wrap(function);
    }

    public static <T> Predicate<T> uncheck(ThrowingPredicate<T, ? extends Throwable> predicate) {
        return PredicateWrapper.wrap(predicate);
    }

    public static <T> Supplier<T> uncheck(ThrowingSupplier<T, ? extends Throwable> supplier) {
        return SupplierWrapper.wrap(supplier);
    }

    public static <T, U> BiConsumer<T, U> uncheck(ThrowingBiConsumer<T, U, ? extends Throwable> biConsumer) {
        return BiConsumerWrapper.wrap(biConsumer);
    }

    public static <T, U, R> BiFunction<T, U, R> uncheck(ThrowingBiFunction<T, U, R, ? extends Throwable> biFunction) {
        return BiFunctionWrapper.wrap(biFunction);
    }

    public static <T, U> BiPredicate<T, U> uncheck(ThrowingBiPredicate<T, U, ? extends Throwable> biPredicate) {
        return BiPredicateWrapper.wrap(biPredicate);
    }
}
