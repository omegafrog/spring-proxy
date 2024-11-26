package hello.proxy.config.v1_dynamicProxy.handler;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogTraceHandler implements InvocationHandler {
    private final Object target;
    private final LogTrace trace;

    public LogTraceHandler(Object target, LogTrace trace) {
        this.target = target;
        this.trace = trace;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        TraceStatus status = null;
        try {
            status = trace.begin(method.getName());

            //로직 호출
            Object result = method.invoke(target, args);

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
