package hello.proxy.config.concrete_proxy;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.app.v2.OrderControllerV2;

public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy( OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

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
