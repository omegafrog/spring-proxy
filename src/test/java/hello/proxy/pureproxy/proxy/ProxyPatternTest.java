package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.ProxySubject;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest(){
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute(); // 불변 데이터라면 계속 처음부터 가져와서 낭비
        client.execute(); // 이걸 프록시를 이용해서 낭비되지 않도록 캐싱해보자
        client.execute();
    }
    @Test
    void proxyTest(){
        ProxySubject subject = new ProxySubject(new RealSubject());
        ProxyPatternClient client = new ProxyPatternClient(subject);
        client.execute();
        client.execute();
        client.execute();
    }

}
