package hello.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AClass implements AInterface {
    @Override
    public String call() {
        log.info("A 호출");
        return "A";
    }

    @Override
    public String callB() {
        log.info("CallB 호출");
        return "AB";
    }
}
