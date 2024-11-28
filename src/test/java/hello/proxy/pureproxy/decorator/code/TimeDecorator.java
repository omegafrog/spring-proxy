package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component {

    private final Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String execute() {
        log.info("start timeDecorator");
        long start = System.currentTimeMillis();
        String  res = component.execute();
        long end = System.currentTimeMillis();
        log.info("end timeDecorator");
        log.info("resultTime : {}", end - start);
        return res;
    }
}
