package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator extends Decorator implements Component {

    public TimeDecorator(Component target) {
        super(target);
    }

    @Override
    public String operation() {
        long startMilli = System.currentTimeMillis();
        String result = target.operation();
        long endMilli = System.currentTimeMillis();
        log.info("result time = {}", endMilli - startMilli);
        return result;
    }
}
