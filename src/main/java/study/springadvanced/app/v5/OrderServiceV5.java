package study.springadvanced.app.v5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.springadvanced.trace.callback.TraceCallBack;
import study.springadvanced.trace.callback.TraceTemplate;
import study.springadvanced.trace.logtrace.LogTrace;
import study.springadvanced.trace.template.AbstractTemplate;

@Service    // @Component 어노테이션 포함하고 있기때문에 스캔대상이 되고 자동으로 스프링 빈에 등록됌
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderService.request()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
