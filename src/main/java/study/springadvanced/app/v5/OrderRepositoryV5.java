package study.springadvanced.app.v5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.springadvanced.trace.callback.TraceTemplate;
import study.springadvanced.trace.logtrace.LogTrace;
import study.springadvanced.trace.template.AbstractTemplate;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId) {
        template.execute("OrderRepository.save()", () -> {
            // 저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);    // 상품을 저장하는데 1초가 거린다고 가정
            return null;
        });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
