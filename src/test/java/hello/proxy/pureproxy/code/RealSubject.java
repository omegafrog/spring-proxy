package hello.proxy.pureproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {
    @Override
    public String logic() {
        log.info("Call real instance");
        sleep(1000);
        return "data";
    }

    private void sleep(int milli) {
        try {
            Thread.sleep(milli);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
