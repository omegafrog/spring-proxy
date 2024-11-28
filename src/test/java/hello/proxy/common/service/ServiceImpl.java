package hello.proxy.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl implements ServiceInterface {
    @Override
    public void A() {
        log.info("A");
    }

    @Override
    public void B() {
        log.info("B");
    }
}
