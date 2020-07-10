package com.github.thedeadone.unchecker;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;


public class RunnableWrapper extends BaseWrapper {
    private static final MethodType RUNNABLE_TYPE = MethodType.methodType(void.class);

    public static Runnable wrap(ThrowingRunnable<? extends Exception> runnable) {
        try {
            MethodHandle factory = createFactory(ThrowingRunnable.class, Runnable.class, RUNNABLE_TYPE, "run");
            return (Runnable) factory.invokeExact(runnable);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}
