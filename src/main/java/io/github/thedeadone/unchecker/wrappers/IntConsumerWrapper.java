package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingIntConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntConsumer;

public class IntConsumerWrapper extends BaseWrapper {
    private static final MethodType INTCONSUMER_TYPE = MethodType.methodType(void.class, int.class);

    public static IntConsumer wrap(ThrowingIntConsumer<? extends Throwable> intConsumer) {
        try {
            MethodHandle factory = createFactory(ThrowingIntConsumer.class, IntConsumer.class,
                INTCONSUMER_TYPE, "accept");
            return (IntConsumer) factory.invokeExact(intConsumer);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

