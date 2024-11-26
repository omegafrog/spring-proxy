package hello.proxy.config.v1_dynamicProxy;

import hello.proxy.app.v1.*;
import hello.proxy.config.v1_dynamicProxy.handler.LogTraceFilterHandler;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class FilteredDynamicProxyConfig {

    private final String[] PATTERN = {"request*", "order*", "save*"};
    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace){
        OrderControllerV1 orderControllerV1 = new OrderControllerV1Impl(orderServiceV1(logTrace));
        LogTraceFilterHandler handler = new LogTraceFilterHandler(orderControllerV1, logTrace, PATTERN);
        OrderControllerV1 proxy = (OrderControllerV1) Proxy.newProxyInstance(
                OrderControllerV1.class.getClassLoader(), new Class[]{OrderControllerV1.class}, handler);
        return proxy;
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace){
        OrderServiceV1 orderServiceV1 = new OrderServiceV1Impl(orderRepositoryV1(logTrace));
        LogTraceFilterHandler handler = new LogTraceFilterHandler(orderServiceV1, logTrace, PATTERN);
        OrderServiceV1 proxy = (OrderServiceV1) Proxy.newProxyInstance(
                OrderServiceV1.class.getClassLoader(), new Class[]{OrderServiceV1.class}, handler);
        return proxy;
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace) {
        OrderRepositoryV1 orderRepositoryV1 = new OrderRepositoryV1Impl();
        LogTraceFilterHandler handler = new LogTraceFilterHandler(orderRepositoryV1, logTrace, PATTERN);
        OrderRepositoryV1 proxy = (OrderRepositoryV1) Proxy.newProxyInstance(
                OrderRepositoryV1.class.getClassLoader(), new Class[]{OrderRepositoryV1.class}, handler);
        return proxy;
    }
}
