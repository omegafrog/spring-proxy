package hello.proxy.config;

import hello.proxy.app.v1.*;
import hello.proxy.config.interface_proxy.OrderControllerInterfaceProxy;
import hello.proxy.config.interface_proxy.OrderRepositoryInterfaceProxy;
import hello.proxy.config.interface_proxy.OrderServiceInterfaceProxy;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    OrderControllerV1 orderControllerV1(LogTrace logTrace){
        OrderControllerV1Impl orderControllerV1 = new OrderControllerV1Impl(orderServiceV1(logTrace));
        return new OrderControllerInterfaceProxy(orderControllerV1, logTrace);
    }

    @Bean
    OrderServiceV1 orderServiceV1(LogTrace logTrace){
        OrderServiceV1Impl orderServiceV1 = new OrderServiceV1Impl(orderRepositoryV1(logTrace));
        return new OrderServiceInterfaceProxy(orderServiceV1, logTrace);
    }

    @Bean
    OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace){
        OrderRepositoryV1Impl orderRepositoryV1 = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(orderRepositoryV1, logTrace);
    }

}
