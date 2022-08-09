package study.springadvanced.app.proxy.config.v1_prroxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import study.springadvanced.app.proxy.v1.OrderServiceV1;
import study.springadvanced.trace.TraceStatus;
import study.springadvanced.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final LogTrace logTrace;

    @Override
    public void orderItem(String itemId) {

        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderService.orderItem()");
            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
