package hello.proxy.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanPostProcessorTest {

    @Test
    void basicTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        B beanA = applicationContext.getBean("beanA", B.class);
        beanA.logic();

//        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
//                () -> applicationContext.getBean("beanB", B.class)
//        );
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
        @Bean
        AToBBeanProcessor postProcessor(){
            return new AToBBeanProcessor();
        }
    }

    @Slf4j
    static class AToBBeanProcessor implements BeanPostProcessor{
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            log.info("Bean name={} bean={}", beanName, bean);
            if(bean instanceof A){
                return new B();
            }
            return bean;
        }
    }
}
