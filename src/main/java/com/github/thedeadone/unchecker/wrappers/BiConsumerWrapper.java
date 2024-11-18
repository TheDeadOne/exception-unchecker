package com.github.thedeadone.unchecker.wrappers;

import com.github.thedeadone.unchecker.interfaces.ThrowingBiConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.BiConsumer;

public class BiConsumerWrapper extends BaseWrapper {
    private static final MethodType BICONSUMER_TYPE = MethodType.methodType(void.class, Object.class, Object.class);

    public static <T, U> BiConsumer<T, U> wrap(ThrowingBiConsumer<T, U, ? extends Throwable> biConsumer) {
        try {
            MethodHandle factory = createFactory(ThrowingBiConsumer.class, BiConsumer.class, BICONSUMER_TYPE, "accept");
            return (BiConsumer<T, U>) factory.invokeExact(biConsumer);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

