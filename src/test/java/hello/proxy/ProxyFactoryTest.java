package hello.proxy;

import hello.proxy.common.advice.TimeAdvice;
import hello.proxy.common.service.ServiceImpl;
import hello.proxy.common.service.ServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

public class ProxyFactoryTest {

    @Test
    void proxyFactoryTest(){
        ServiceInterface target = new ServiceImpl();
        ProxyFactory factory = new ProxyFactory(target);
        factory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) factory.getProxy();
        proxy.A();
        proxy.B();

    }
}
