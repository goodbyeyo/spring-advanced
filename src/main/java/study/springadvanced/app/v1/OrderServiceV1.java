package study.springadvanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.springadvanced.trace.TraceStatus;
import study.springadvanced.trace.hellotrace.HelloTraceV1;

@Service    // @Component 어노테이션 포함하고 있기때문에 스캔대상이 되고 자동으로 스프링 빈에 등록됌
@RequiredArgsConstructor  // 생성자 자동으로 생성
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.request()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;    // 예외를 반드시 다시 던져주어야 한다
        }

    }


    
}
