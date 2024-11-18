package com.github.thedeadone.unchecker.wrappers;

import com.github.thedeadone.unchecker.interfaces.ThrowingLongToDoubleFunction;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.LongToDoubleFunction;

public class LongToDoubleFunctionWrapper extends BaseWrapper {
    private static final MethodType LONGTODOUBLEFUNCTION_TYPE = MethodType.methodType(double.class, long.class);

    public static LongToDoubleFunction wrap(ThrowingLongToDoubleFunction<? extends Throwable> longToDoubleFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingLongToDoubleFunction.class, LongToDoubleFunction.class,
                LONGTODOUBLEFUNCTION_TYPE, "applyAsDouble");
            return (LongToDoubleFunction) factory.invokeExact(longToDoubleFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

