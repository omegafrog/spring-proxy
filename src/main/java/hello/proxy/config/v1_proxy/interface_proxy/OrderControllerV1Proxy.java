package hello.proxy.config.v1_proxy.interface_proxy;

import hello.proxy.app.v1.OrderControllerV1;
import hello.proxy.trace.callback.TraceCallback;
import hello.proxy.trace.callback.TraceTemplate;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderControllerV1Proxy implements OrderControllerV1 {
    private final OrderControllerV1 target;
    private final TraceTemplate template;

    public OrderControllerV1Proxy(OrderControllerV1 target, LogTrace logTrace) {
        this.target = target;
        this.template = new TraceTemplate(logTrace);
    }

    @Override
    public String request(String itemId) {
        return template.execute("OrderController.request()",
                new TraceCallback<String>() {
                    @Override
                    public String call() {
                        return target.request(itemId);
                    }
                });
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
