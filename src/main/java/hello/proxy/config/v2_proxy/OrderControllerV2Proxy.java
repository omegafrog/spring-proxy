package hello.proxy.config.v2_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.callback.TraceTemplate;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderControllerV2Proxy extends OrderControllerV2 {
    public OrderControllerV2Proxy( OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.template = new TraceTemplate(logTrace);
    }

    private final OrderControllerV2 target;
    private final TraceTemplate template;
    @Override
    public String noLog() {
        return target.noLog();
    }

    @Override
    public String request(String itemId) {
        return template.execute("OrderController.request()", () -> target.request(itemId));
    }


}
