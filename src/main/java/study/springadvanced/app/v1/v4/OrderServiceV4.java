package study.springadvanced.app.v1.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.springadvanced.trace.logtrace.LogTrace;
import study.springadvanced.trace.template.AbstractTemplate;

@Service    // @Component 어노테이션 포함하고 있기때문에 스캔대상이 되고 자동으로 스프링 빈에 등록됌
@RequiredArgsConstructor  // 생성자 자동으로 생성
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.request()");
    }
}
