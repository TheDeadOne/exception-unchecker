package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingObjDoubleConsumer;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ObjDoubleConsumer;

public class ObjDoubleConsumerWrapper extends BaseWrapper {
    private static final MethodType OBJDOUBLECONSUMER_TYPE = MethodType.methodType(void.class,
        Object.class, double.class);

    public static <T> ObjDoubleConsumer<T> wrap(ThrowingObjDoubleConsumer<T, ? extends Throwable> objDoubleConsumer) {
        try {
            MethodHandle factory = createFactory(ThrowingObjDoubleConsumer.class, ObjDoubleConsumer.class,
                OBJDOUBLECONSUMER_TYPE, "accept");
            return (ObjDoubleConsumer<T>) factory.invokeExact(objDoubleConsumer);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

