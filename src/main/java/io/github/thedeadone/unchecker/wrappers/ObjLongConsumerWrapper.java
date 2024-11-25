package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingObjLongConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ObjLongConsumer;

public class ObjLongConsumerWrapper extends BaseWrapper {
    private static final MethodType OBJLONGCONSUMER_TYPE = MethodType.methodType(void.class, Object.class, long.class);

    public static <T> ObjLongConsumer<T> wrap(ThrowingObjLongConsumer<T, ? extends Throwable> objLongConsumer) {
        try {
            MethodHandle factory = createFactory(ThrowingObjLongConsumer.class, ObjLongConsumer.class,
                OBJLONGCONSUMER_TYPE, "accept");
            return (ObjLongConsumer<T>) factory.invokeExact(objLongConsumer);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

