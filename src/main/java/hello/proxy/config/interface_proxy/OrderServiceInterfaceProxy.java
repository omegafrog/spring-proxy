package hello.proxy.config.interface_proxy;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.app.v1.OrderServiceV1;

public class OrderServiceInterfaceProxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final LogTrace logTrace;

    public OrderServiceInterfaceProxy(OrderServiceV1 target, LogTrace logTrace) {
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
