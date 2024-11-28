package hello.proxy;

import hello.proxy.cglib.TimeMethodInterceptor;
import hello.proxy.common.service.ConcreteService;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

public class CglibTest {

    @Test
    void cglibTest(){
        ConcreteService target= new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        ConcreteService proxy = (ConcreteService) enhancer.create();

        proxy.A();
        proxy.B();
    }
}
