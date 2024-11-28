package hello.proxy.jdkDynamic;

import hello.proxy.jdkDynamic.code.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

public class JdkDynamicProxyTest {

    @Test
    void dynamicA(){
        AInterface a = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(a);

        AInterface proxyInstance = (AInterface) Proxy.newProxyInstance(
                AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);
        proxyInstance.call();
    }
    @Test
    void dynamicB(){
        BInterface b = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(b);

        BInterface proxyInstance = (BInterface) Proxy.newProxyInstance(
                BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);
        proxyInstance.call();
    }
}
