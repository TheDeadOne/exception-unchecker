package dev.gornostaev;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import java.util.function.IntToDoubleFunction;


public class IntToDoubleFunctionWrapper extends BaseWrapper {
    private static final MethodType INTTODOUBLEFUNCTION_TYPE = MethodType.methodType(double.class, int.class);

    public static IntToDoubleFunction wrap(ThrowingIntToDoubleFunction<? extends Exception> intToDoubleFunction) {
        try {
            MethodHandle factory = createFactory(ThrowingIntToDoubleFunction.class, IntToDoubleFunction.class,
                INTTODOUBLEFUNCTION_TYPE, "applyAsDouble");
            return (IntToDoubleFunction) factory.invokeExact(intToDoubleFunction);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}

