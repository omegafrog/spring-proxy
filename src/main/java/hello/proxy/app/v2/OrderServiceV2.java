package hello.proxy.app.v2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;

    public OrderServiceV2(OrderRepositoryV2 orderRepositoryV2) {
        this.orderRepositoryV2 = orderRepositoryV2;
    }

    public void order(String itemId) {
        orderRepositoryV2.save(itemId);
    }
}
