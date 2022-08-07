package study.springadvanced.app.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.springadvanced.trace.TraceStatus;
import study.springadvanced.trace.hellotrace.HelloTraceV2;
import study.springadvanced.trace.logtrace.LogTrace;

// Controller와 ResponseBody가 합쳐진것
@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;    // 예외를 반드시 다시 던져주어야 한다
        }
    }
}
