package hello.proxy;

import hello.proxy.config.v3_proxyFactory.AutoProxyConfig;
import hello.proxy.config.v3_proxyFactory.BeanPostProcessorConfig;
import hello.proxy.config.v3_proxyFactory.ProxyFactoryConfigV1;
import hello.proxy.config.v3_proxyFactory.ProxyFactoryConfigV2;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


//@Import({AppConfigV1.class, AppConfigV2.class})
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import({ProxyFactoryConfigV1.class, ProxyFactoryConfigV2.class})
//@Import(BeanPostProcessorConfig.class)
@Import(AutoProxyConfig.class)
@SpringBootApplication(scanBasePackages = "hello.proxy.app") //주의 일부로 app 아래만 컴포넌트스캔하도록
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}


	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
