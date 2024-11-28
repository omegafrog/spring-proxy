package hello.proxy.config.concrete_proxy;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.app.v2.OrderServiceV2;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;

    private final LogTrace logTrace;

    public OrderServiceConcreteProxy( OrderServiceV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    TraceStatus status = null;

    @Override
    public void order(String itemId) {
        try {
            status = logTrace.begin("OrderService.order()");
            target.order(itemId);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }
}
