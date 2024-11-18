package com.github.thedeadone.unchecker.wrappers;

import com.github.thedeadone.unchecker.interfaces.ThrowingRunnable;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class RunnableWrapper extends BaseWrapper {
    private static final MethodType RUNNABLE_TYPE = MethodType.methodType(void.class);

    public static Runnable wrap(ThrowingRunnable<? extends Throwable> runnable) {
        try {
            MethodHandle factory = createFactory(ThrowingRunnable.class, Runnable.class, RUNNABLE_TYPE, "run");
            return (Runnable) factory.invokeExact(runnable);
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}
