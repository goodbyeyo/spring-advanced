package study.springadvanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import study.springadvanced.trace.strategy.code.template.CallBack;
import study.springadvanced.trace.strategy.code.template.TimeLogTemplate;

@Slf4j
public class TemplateCallbackTest {

    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });

        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
    }

    /**
     * 템플릿 콜백 패턴 - 람
     */
    @Test
    void callbackV2() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("비즈니스 로직 1 실행"));
        template.execute(() -> log.info("비즈니스 로직 2 실행"));
    }

}
