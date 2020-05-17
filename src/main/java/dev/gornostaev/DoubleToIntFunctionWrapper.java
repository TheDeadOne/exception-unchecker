package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.DoubleToIntFunction;


public class DoubleToIntFunctionWrapper extends BaseWrapper {
    private static final MethodType DOUBLETOINTFUNCTION_TYPE = MethodType.methodType(int.class, double.class);

    public static DoubleToIntFunction wrap(ThrowingDoubleToIntFunction<? extends Exception> doubleToIntFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingDoubleToIntFunction.class, DoubleToIntFunction.class,
                DOUBLETOINTFUNCTION_TYPE, "applyAsInt");
            return (DoubleToIntFunction) factory.invokeExact(doubleToIntFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

