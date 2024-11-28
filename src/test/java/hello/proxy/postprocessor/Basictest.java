package hello.proxy.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Basictest {

    @Test
    void basicTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        A beanA = applicationContext.getBean("beanA", A.class);
        beanA.logic();

        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> applicationContext.getBean("beanB", B.class)
        );
    }

    @Slf4j
    static class A{
        public void logic(){
            log.info("A");
        }
    }

    @Slf4j
    static class B{
        public void logic(){
            log.info("B");
        }
    }

    @Slf4j
    @Configuration
    static class Config{
        @Bean(name="beanA")
        A a(){
            return new A();
        }


    }
}
