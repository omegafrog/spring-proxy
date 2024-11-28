package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("start");
        long startMilli = System.currentTimeMillis();

        Object result = invocation.proceed();

        long endMilli = System.currentTimeMillis();
        log.info("resul time : {}", endMilli - startMilli);
        log.info("end");
        return result;
    }
}
