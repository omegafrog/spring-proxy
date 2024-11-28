package hello.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic {
    private final ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operator() {
        log.info("TimeDecorator 실행");
        long start = System.currentTimeMillis();
        String  res = super.operator();
        long end = System.currentTimeMillis();
        log.info("resultTime : {}", end - start);
        log.info("TimeDecorator 종료");
        
        return res;
    }
}
