package com.github.thedeadone.unchecker;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.Supplier;


public class SupplierWrapper extends BaseWrapper {
    private static final MethodType SUPPLIER_TYPE = MethodType.methodType(Object.class);

    public static <T> Supplier<T> wrap(ThrowingSupplier<T, ? extends Exception> supplier) {
        try {
            MethodHandle factory = createFactory(ThrowingSupplier.class, Supplier.class, SUPPLIER_TYPE, "get");
            return (Supplier<T>) factory.invokeExact(supplier);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}
