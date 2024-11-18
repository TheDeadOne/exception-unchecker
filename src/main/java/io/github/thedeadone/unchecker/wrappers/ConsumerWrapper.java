package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.Consumer;

public class ConsumerWrapper extends BaseWrapper {
    private static final MethodType CONSUMER_TYPE = MethodType.methodType(void.class, Object.class);

    public static <T> Consumer<T> wrap(ThrowingConsumer<T, ? extends Throwable> consumer) {
        try {
            MethodHandle factory = createFactory(ThrowingConsumer.class, Consumer.class, CONSUMER_TYPE, "accept");
            return (Consumer<T>) factory.invokeExact(consumer);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}
