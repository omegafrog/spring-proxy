package hello.proxy.config.v1_proxy.interface_proxy;

import hello.proxy.app.v1.OrderRepositoryV1;
import hello.proxy.trace.callback.TraceCallback;
import hello.proxy.trace.callback.TraceTemplate;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderRepositoryV1Proxy implements OrderRepositoryV1 {
    private final TraceTemplate template;
    private final OrderRepositoryV1 target;

    public OrderRepositoryV1Proxy(OrderRepositoryV1 target, LogTrace logTrace) {
        this.template = new TraceTemplate(logTrace);
        this.target = target;
    }

    @Override
    public void save(String itemId) {
        template.execute("OrderRepository.save()",
                new TraceCallback<Void>() {
                    @Override
                    public Void call() {
                        target.save(itemId);
                        return null;
                    }
                });
    }
}
