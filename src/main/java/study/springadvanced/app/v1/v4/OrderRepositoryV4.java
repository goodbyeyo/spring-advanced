package study.springadvanced.app.v1.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.springadvanced.trace.TraceStatus;
import study.springadvanced.trace.logtrace.LogTrace;
import study.springadvanced.trace.template.AbstractTemplate;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생!");
                }
                sleep(1000);    // 상품을 저장하는데 1초가 거린다고 가정
                return null;
            }
        };
        template.execute("OrderRepository.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
