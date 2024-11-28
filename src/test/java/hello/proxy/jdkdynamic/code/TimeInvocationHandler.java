package hello.proxy.jdkDynamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

    private final Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("start");
        long startMilli = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long endMilli = System.currentTimeMillis();
        log.info("resul time : {}", endMilli - startMilli);
        log.info("end");
        return result;
    }
}
