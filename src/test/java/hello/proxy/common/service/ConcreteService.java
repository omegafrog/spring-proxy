package hello.proxy.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteService {

    public void A(){
        log.info("A");
    }
    public void B(){
        log.info("B");
    }
}
