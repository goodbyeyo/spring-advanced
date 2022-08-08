package study.springadvanced.app.proxy.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping //스프링은 @Controller 또는 @RequestMapping 이 있어야 스프링 컨트롤러로 인식
@ResponseBody   //  HTTP 메시지 컨버터를 사용해서 응답
public interface OrderControllerV1 {

    @GetMapping("/v1/request")  // @RequestParam("itemId") 의 값을 생략하면 자바 버전에 따라 인식하지 못할 수 있다
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
