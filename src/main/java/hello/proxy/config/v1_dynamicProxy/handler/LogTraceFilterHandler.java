package hello.proxy.config.v1_dynamicProxy.handler;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class LogTraceFilterHandler implements InvocationHandler {
    private final Object target;
    private final LogTrace trace;
    private final String[] patterns;

    public LogTraceFilterHandler(Object target, LogTrace trace, String[] pattern) {
        this.target = target;
        this.trace = trace;
        this.patterns = pattern;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean matches = PatternMatchUtils.simpleMatch(patterns, method.getName());
        if(matches){
            return method.invoke(target,args);
        }
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
