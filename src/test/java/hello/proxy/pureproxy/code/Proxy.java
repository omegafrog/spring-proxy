package hello.proxy.pureproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Proxy implements Subject {

    // 프록시에서 조회할 새로운 데이터
    private Subject target;

    private String cacheData;

    public Proxy(Subject target) {
        this.target = target;
    }

    @Override
    public String logic() {
        log.info("call proxy");
        if(cacheData == null){
            cacheData = target.logic();
        }
        return cacheData;
    }
}
