package study.springadvanced.app.v5;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.springadvanced.trace.callback.TraceCallBack;
import study.springadvanced.trace.callback.TraceTemplate;
import study.springadvanced.trace.logtrace.LogTrace;
import study.springadvanced.trace.template.AbstractTemplate;

// Controller와 ResponseBody가 합쳐진것
@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        // 의존관계 주입을 받으면서 필요한 TraceTemplate 템플릿 생성
        // TraceTemplate 을 처음부터 스프링 빈으로 등록하고 빈으로 주입받아도 된다
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        // 템플릿을 실행하면서 콜백을 전달한다

        return template.execute("OrderController.request()", () -> {    // 람다
            orderService.orderItem(itemId);
            return "ok";
        });
//        return template.execute("OrderController.request()", new TraceCallBack<>() {   // 악명 내부클래스
//            @Override
//            public String call() {
//                orderService.orderItem(itemId);
//                return "ok";
//            }
//        });
    }
}
