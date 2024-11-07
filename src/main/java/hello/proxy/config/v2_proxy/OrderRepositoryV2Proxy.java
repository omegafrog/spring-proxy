package hello.proxy.config.v2_proxy;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.trace.callback.TraceCallback;
import hello.proxy.trace.callback.TraceTemplate;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderRepositoryV2Proxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final TraceTemplate template;

    public OrderRepositoryV2Proxy(OrderRepositoryV2 target, LogTrace trace) {
        this.target = target;
        this.template = new TraceTemplate(trace);
    }
    @Override
    public void save(String itemId) {
        template.execute("OrderRepository.save()", (TraceCallback<Void>) () -> {
            target.save(itemId);
            return null;
        });
    }
}
