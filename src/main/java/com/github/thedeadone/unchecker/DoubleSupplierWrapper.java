package com.github.thedeadone.unchecker;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleSupplier;


public class DoubleSupplierWrapper extends BaseWrapper {
    private static final MethodType DOUBLESUPPLIER_TYPE = MethodType.methodType(double.class);

    public static DoubleSupplier wrap(ThrowingDoubleSupplier<? extends Exception> doubleSupplier) {
        try {
            MethodHandle factory = createFactory(ThrowingDoubleSupplier.class, DoubleSupplier.class,
                DOUBLESUPPLIER_TYPE, "getAsDouble");
            return (DoubleSupplier) factory.invokeExact(doubleSupplier);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

