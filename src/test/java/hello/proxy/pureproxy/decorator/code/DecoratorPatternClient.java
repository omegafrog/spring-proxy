package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorPatternClient {

    private final Component component;

    public DecoratorPatternClient(Component component) {
        this.component = component;
    }
    public void execute(){
        String res = component.execute();
        log.info("component 실행 종료");
        log.info("res : {}", res);
    }
}
