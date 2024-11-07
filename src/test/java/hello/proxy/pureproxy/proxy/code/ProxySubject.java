package hello.proxy.pureproxy.proxy.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class ProxySubject implements Subject {

    private String cacheValue;
    private final Subject target;
    @Override
    public String operation() {
        if(cacheValue == null){
            cacheValue = target.operation();
        }
        else{
            log.info("캐시 사용");
        }
        return cacheValue;
    }
}
