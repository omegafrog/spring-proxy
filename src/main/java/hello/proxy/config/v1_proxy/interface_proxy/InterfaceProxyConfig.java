package hello.proxy.config.v1_proxy.interface_proxy;

import hello.proxy.app.v1.*;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {
    @Bean
    public OrderServiceV1 orderServiceV1Proxy(){
        OrderServiceV1Impl orderServiceV1 = new OrderServiceV1Impl(orderRepositoryV1Proxy());
        return new OrderServiceV1Proxy(orderServiceV1, threadLocalLogTrace());
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1Proxy(){
        OrderRepositoryV1Impl orderRepositoryV1 = new OrderRepositoryV1Impl();
        return new OrderRepositoryV1Proxy(orderRepositoryV1, threadLocalLogTrace());
    }

    @Bean
    public OrderControllerV1 orderControllerV1Proxy(){
        OrderControllerV1Impl orderControllerV1 = new OrderControllerV1Impl(orderServiceV1Proxy());
        return new OrderControllerV1Proxy(orderControllerV1, threadLocalLogTrace());
    }
    @Bean
    public LogTrace threadLocalLogTrace(){
        return new ThreadLocalLogTrace();
    }
}
