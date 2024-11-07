package hello.proxy.config.v1_proxy.interface_proxy;

import hello.proxy.app.v1.*;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {
    @Bean
    public OrderServiceV1 orderServiceV1Proxy(LogTrace logTrace){
        OrderServiceV1Impl orderServiceV1 = new OrderServiceV1Impl(orderRepositoryV1Proxy(logTrace));
        return new OrderServiceV1Proxy(orderServiceV1, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1Proxy(LogTrace logTrace){
        OrderRepositoryV1Impl orderRepositoryV1 = new OrderRepositoryV1Impl();
        return new OrderRepositoryV1Proxy(orderRepositoryV1, logTrace);
    }

    @Bean
    public OrderControllerV1 orderControllerV1Proxy(LogTrace logTrace){
        OrderControllerV1Impl orderControllerV1 = new OrderControllerV1Impl(orderServiceV1Proxy(logTrace));
        return new OrderControllerV1Proxy(orderControllerV1, logTrace);
    }

}
