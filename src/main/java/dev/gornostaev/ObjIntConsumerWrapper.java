package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.ObjIntConsumer;


public class ObjIntConsumerWrapper extends BaseWrapper {
    private static final MethodType OBJINTCONSUMER_TYPE = MethodType.methodType(void.class, Object.class, int.class);

    public static <T> ObjIntConsumer<T> wrap(ThrowingObjIntConsumer<T, ? extends Exception> objIntConsumer) {
        try {
            MethodHandle factory = createFactory(ThrowingObjIntConsumer.class, ObjIntConsumer.class,
                OBJINTCONSUMER_TYPE, "accept");
            return (ObjIntConsumer<T>) factory.invokeExact(objIntConsumer);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

