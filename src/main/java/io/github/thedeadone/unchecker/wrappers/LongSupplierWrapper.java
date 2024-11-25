package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingLongSupplier;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongSupplier;

public class LongSupplierWrapper extends BaseWrapper {
    private static final MethodType LONGSUPPLIER_TYPE = MethodType.methodType(long.class);

    public static LongSupplier wrap(ThrowingLongSupplier<? extends Throwable> longSupplier) {
        try {
            MethodHandle factory = createFactory(ThrowingLongSupplier.class, LongSupplier.class,
                LONGSUPPLIER_TYPE, "getAsLong");
            return (LongSupplier) factory.invokeExact(longSupplier);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

