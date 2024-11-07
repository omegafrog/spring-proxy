package hello.proxy.config.v1_proxy.interface_proxy;

import hello.proxy.app.v1.OrderServiceV1;
import hello.proxy.trace.callback.TraceTemplate;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderServiceV1Proxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final TraceTemplate template;

    public OrderServiceV1Proxy(OrderServiceV1 target, LogTrace logTrace) {
        this.target = target;
        this.template = new TraceTemplate(logTrace);
    }

    @Override
    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", () -> {
            target.orderItem(itemId);
            return null;
        });
    }
}
