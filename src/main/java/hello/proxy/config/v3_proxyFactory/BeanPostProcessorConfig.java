package hello.proxy.config.v3_proxyFactory;

import hello.proxy.config.AppConfigV1;
import hello.proxy.config.AppConfigV2;
import hello.proxy.config.v3_proxyFactory.advicor.LogTraceAdvice;
import hello.proxy.config.v3_proxyFactory.beanpostprocessor.LogTraceBeanPostProcessor;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppConfigV1.class, AppConfigV2.class})
public class BeanPostProcessorConfig {

    @Bean
    public LogTraceBeanPostProcessor logTraceBeanPostProcessor(LogTrace logTrace){
        return new LogTraceBeanPostProcessor(logTrace, "hello.proxy.app", getAdvisor(logTrace));
    }
    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");

        LogTraceAdvice logTraceAdvice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, logTraceAdvice);
    }
}
