package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component {
    @Override
    public String execute() {
        log.info("component 시작");
        log.info("component 종료");
        sleep(500);
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
