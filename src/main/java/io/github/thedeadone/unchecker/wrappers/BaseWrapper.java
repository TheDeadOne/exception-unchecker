package io.github.thedeadone.unchecker.wrappers;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

class BaseWrapper {
    private static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();

    protected BaseWrapper() {  }

    protected static MethodHandle createFactory(Class<?> targetClass, Class<?> wrapperClass, MethodType methodType,
      String methodName) {
        try {
            MethodHandle method = LOOKUP.findVirtual(targetClass, methodName, methodType);
            MethodType factoryType = MethodType.methodType(wrapperClass, targetClass);
            CallSite site = LambdaMetafactory.metafactory(LOOKUP, methodName, factoryType,
                methodType, method, methodType);
            return site.getTarget();
        } catch (Throwable exc) {
            throw new ExceptionInInitializerError(exc);
        }
    }
}
