package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorateTest(){
        Component realComponent = new RealComponent();
        Component decorateComponent = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(decorateComponent);
        client.execute();
    }
    @Test
    void decorateTest2(){
        Component realComponent = new RealComponent();
        Component decorateComponent = new MessageDecorator(realComponent);
        Component timeDecorator = new TimeDecorator(decorateComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }
}
