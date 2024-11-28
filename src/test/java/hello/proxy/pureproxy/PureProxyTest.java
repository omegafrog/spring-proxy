package hello.proxy.pureproxy;

import hello.proxy.pureproxy.code.Proxy;
import hello.proxy.pureproxy.code.ProxyClient;
import hello.proxy.pureproxy.code.RealSubject;
import hello.proxy.pureproxy.code.Subject;
import org.junit.jupiter.api.Test;

public class PureProxyTest {
    @Test
    void noProxyTest(){
        RealSubject subject = new RealSubject();
        ProxyClient client = new ProxyClient(subject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void proxyTest(){
        Subject subject = new RealSubject();
        Proxy proxy = new Proxy(subject);
        ProxyClient client = new ProxyClient(proxy);
        // client -> proxy ->subject
        client.execute();
        client.execute();
        client.execute();

    }
}
