package hello.proxy.config;

import hello.proxy.config.concrete_proxy.OrderControllerConcreteProxy;
import hello.proxy.config.concrete_proxy.OrderRepositoryConcreteProxy;
import hello.proxy.config.concrete_proxy.OrderServiceConcreteProxy;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    private final LogTrace logTrace;

    public ConcreteProxyConfig(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    @Bean
    OrderControllerV2 orderControllerV2(){
        OrderControllerV2 orderControllerImpl = new OrderControllerV2(orderServiceV2());
        return new OrderControllerConcreteProxy(orderControllerImpl,logTrace);
    }

    @Bean
    OrderServiceV2 orderServiceV2(){
        OrderServiceV2 orderServiceImpl = new OrderServiceV2(orderRepositoryV2());
        return new OrderServiceConcreteProxy(orderServiceImpl, logTrace);
    }

    @Bean
    OrderRepositoryV2 orderRepositoryV2(){
        OrderRepositoryV2 orderRepositoryV2 = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(orderRepositoryV2, logTrace);
    }
}
