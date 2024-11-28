package hello.proxy.cglib;

import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("start");
        long startMilli = System.currentTimeMillis();

        Object result = methodProxy.invoke(target, args);
//        Object result = method.invoke(target, args);

        long endMilli = System.currentTimeMillis();
        log.info("resul time : {}", endMilli - startMilli);
        log.info("end");
        return result;
    }
}
