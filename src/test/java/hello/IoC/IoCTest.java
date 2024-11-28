package hello.IoC;

import hello.proxy.jdkDynamic.code.BInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class IoCTest {
    @Configuration
    static class TestConfig{
        @Bean(name="beanA")
        A a(){
            return new A();
        }
        @Bean(name = "beanB")
        BInterface b(){
            return new B();
        }
    }
    @Test
    void iocTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        A beanA = applicationContext.getBean("beanA", A.class);
        beanA.logic();

    }
    @Slf4j
    static class A {

        @Autowired
        private  BInterface b;
        public void logic() {
            log.info("logic A");
            b.logic();
        }
    }
    @Slf4j
    static class B implements BInterface{
        @Override
        public void logic(){
            log.info("logic B");
        }
    }
    static interface BInterface{
        void logic();
    }

}
