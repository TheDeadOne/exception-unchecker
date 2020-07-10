package com.github.thedeadone.unchecker;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleConsumer;


public class DoubleConsumerWrapper extends BaseWrapper {
    private static final MethodType DOUBLECONSUMER_TYPE = MethodType.methodType(void.class, double.class);

    public static DoubleConsumer wrap(ThrowingDoubleConsumer<? extends Exception> doubleConsumer) {
        try {
            MethodHandle factory = createFactory(ThrowingDoubleConsumer.class, DoubleConsumer.class,
                DOUBLECONSUMER_TYPE, "accept");
            return (DoubleConsumer) factory.invokeExact(doubleConsumer);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

