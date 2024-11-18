package com.github.thedeadone.unchecker.wrappers;

import com.github.thedeadone.unchecker.interfaces.ThrowingDoubleToIntFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleToIntFunction;

public class DoubleToIntFunctionWrapper extends BaseWrapper {
    private static final MethodType DOUBLETOINTFUNCTION_TYPE = MethodType.methodType(int.class, double.class);

    public static DoubleToIntFunction wrap(ThrowingDoubleToIntFunction<? extends Throwable> doubleToIntFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingDoubleToIntFunction.class, DoubleToIntFunction.class,
                DOUBLETOINTFUNCTION_TYPE, "applyAsInt");
            return (DoubleToIntFunction) factory.invokeExact(doubleToIntFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

