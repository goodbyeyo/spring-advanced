package study.springadvanced.app.proxy.config.v1_prroxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import study.springadvanced.app.proxy.v1.OrderRepositoryV1;
import study.springadvanced.trace.TraceStatus;
import study.springadvanced.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {

        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderRepository.request()");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
