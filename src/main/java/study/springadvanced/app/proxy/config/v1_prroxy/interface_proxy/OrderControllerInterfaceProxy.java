package study.springadvanced.app.proxy.config.v1_prroxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import study.springadvanced.app.proxy.v1.OrderControllerV1;
import study.springadvanced.trace.TraceStatus;
import study.springadvanced.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private LogTrace logTrace;

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderController.request()");
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
