package hello.proxy.config.interface_proxy;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.app.v1.OrderRepositoryV1;

public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

    public OrderRepositoryInterfaceProxy(OrderRepositoryV1 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }
    TraceStatus status = null;
    @Override
    public void save(String itemId) {
        try {
            status = logTrace.begin("OrderRepository.request()");
            target.save(itemId);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }

    }
}
