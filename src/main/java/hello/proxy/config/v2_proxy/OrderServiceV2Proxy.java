package hello.proxy.config.v2_proxy;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.callback.TraceTemplate;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderServiceV2Proxy extends OrderServiceV2 {
    private final OrderServiceV2 target;
    private final TraceTemplate template;

    public OrderServiceV2Proxy( OrderServiceV2 target, LogTrace logTrace) {
        super(null);
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
