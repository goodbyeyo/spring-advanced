package study.springadvanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.springadvanced.trace.TraceId;
import study.springadvanced.trace.TraceStatus;
import study.springadvanced.trace.hellotrace.HelloTraceV2;

@Service    // @Component 어노테이션 포함하고 있기때문에 스캔대상이 되고 자동으로 스프링 빈에 등록됌
@RequiredArgsConstructor  // 생성자 자동으로 생성
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderService.request()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;    // 예외를 반드시 다시 던져주어야 한다
        }

    }


    
}
