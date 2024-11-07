package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator extends Decorator implements Component{
    public MessageDecorator(Component target) {
        super(target);
    }

    @Override
    public String operation() {
        log.info("Decorating value start");
        log.info("Decorating value...");
        String res = target.operation()+"**";
        log.info("Decorating value end");
        return res;
    }

}
