package study.springadvanced.app.proxy.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping// 스프링은 @Controller 또는 @RequestMapping 이 있어야 스프링 컨트롤러로 인식(인터페이스에 사용가능)
@ResponseBody   // Http 메시지 컨버터를 사용해서 응답, 인터페이스에 사용가능
public interface OrderControllerV1 {

    @GetMapping("/v1/request")  // LogTrace 를 적용 할 대상
    String request(@RequestParam("itemId") String itemId);  // 인터페이스에는 @RequestParam 필수

    @GetMapping("/v1/no-log")   // LogTrace 를 적용하지 않을 대상
    String noLog();
}

