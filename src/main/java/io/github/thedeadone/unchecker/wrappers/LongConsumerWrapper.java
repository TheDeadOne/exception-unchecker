package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingLongConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongConsumer;

public class LongConsumerWrapper extends BaseWrapper {
    private static final MethodType LONGCONSUMER_TYPE = MethodType.methodType(void.class, long.class);

    public static LongConsumer wrap(ThrowingLongConsumer<? extends Throwable> longConsumer) {
        try {
            MethodHandle factory = createFactory(ThrowingLongConsumer.class, LongConsumer.class,
                LONGCONSUMER_TYPE, "accept");
            return (LongConsumer) factory.invokeExact(longConsumer);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

