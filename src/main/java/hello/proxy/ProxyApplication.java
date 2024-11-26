package hello.proxy;

import hello.proxy.config.v1_dynamicProxy.DynamicProxyConfig;
import hello.proxy.config.v1_dynamicProxy.FilteredDynamicProxyConfig;
import hello.proxy.config.v1_proxy.interface_proxy.InterfaceProxyConfig;
import hello.proxy.config.v2_proxy.ClassConfiguration;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import(AppV2Config.class)
//@Import(InterfaceProxyConfig.class)
//@Import(ClassConfiguration.class)
//@Import(DynamicProxyConfig.class)
@Import(FilteredDynamicProxyConfig.class)
@SpringBootApplication(scanBasePackages = "hello.proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}
	@Bean
	public LogTrace threadLocalLogTrace(){
		return new ThreadLocalLogTrace();
	}
}
