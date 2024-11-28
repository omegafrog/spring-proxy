package hello.proxy.config.interface_proxy;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.app.v1.OrderControllerV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private final LogTrace logTrace;

    TraceStatus status;
    @Override
    public String request(String itemId) {
        try{
            status = logTrace.begin("OrderController.request()");
            target.request(itemId);
            logTrace.end(status);
            return "ok";
        }
        catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return "no-log";
    }
}

