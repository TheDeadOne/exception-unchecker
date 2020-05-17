package dev.gornostaev;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;
import java.util.concurrent.Callable;


/**
 * Хэлпер для распростанённых враперов
 */
public final class ExceptionUnchecker {
    private ExceptionUnchecker() {  }

    public static Runnable uncheck(ThrowingRunnable<? extends Exception> runnable) {
        return RunnableWrapper.wrap(runnable);
    }

    public static <T> Consumer<T> uncheck(ThrowingConsumer<T, ? extends Exception> consumer) {
        return ConsumerWrapper.wrap(consumer);
    }

    public static <T, R> Function<T, R> uncheck(ThrowingFunction<T, R, ? extends Exception> function) {
        return FunctionWrapper.wrap(function);
    }

    public static <T> Predicate<T> uncheck(ThrowingPredicate<T, ? extends Exception> predicate) {
        return PredicateWrapper.wrap(predicate);
    }

    public static <T> Supplier<T> uncheck(ThrowingSupplier<T, ? extends Exception> supplier) {
        return SupplierWrapper.wrap(supplier);
    }

    public static <T, U> BiConsumer<T, U> uncheck(ThrowingBiConsumer<T, U, ? extends Exception> biConsumer) {
        return BiConsumerWrapper.wrap(biConsumer);
    }

    public static <T, U, R> BiFunction<T, U, R> uncheck(ThrowingBiFunction<T, U, R, ? extends Exception> biFunction) {
        return BiFunctionWrapper.wrap(biFunction);
    }

    public static <T, U> BiPredicate<T, U> uncheck(ThrowingBiPredicate<T, U, ? extends Exception> biPredicate) {
        return BiPredicateWrapper.wrap(biPredicate);
    }
}
