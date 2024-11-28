package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {

    private final Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String execute() {
        log.info("message decorator 시작");

        String executed = component.execute();
        String decorated = "*" + executed + "*";

        log.info("before : {}, after : {}", executed, decorated);
        log.info("message decorator 종료");
        return decorated;
    }
}
