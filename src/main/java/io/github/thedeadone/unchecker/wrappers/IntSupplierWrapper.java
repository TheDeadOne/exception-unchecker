package io.github.thedeadone.unchecker.wrappers;

import io.github.thedeadone.unchecker.interfaces.ThrowingIntSupplier;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntSupplier;

public class IntSupplierWrapper extends BaseWrapper {
    private static final MethodType INTSUPPLIER_TYPE = MethodType.methodType(int.class);

    public static IntSupplier wrap(ThrowingIntSupplier<? extends Throwable> intSupplier) {
        try {
            MethodHandle factory = createFactory(ThrowingIntSupplier.class, IntSupplier.class,
                INTSUPPLIER_TYPE, "getAsInt");
            return (IntSupplier) factory.invokeExact(intSupplier);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

