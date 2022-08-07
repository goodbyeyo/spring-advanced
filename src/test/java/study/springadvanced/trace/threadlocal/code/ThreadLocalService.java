package study.springadvanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    // Thread <저장할 타입>
    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("저장 name={} --> nameStore={}", name, nameStore.get());
        nameStore.set(name);    // 객체이기때문에 메서드를 통해 값 넣는다
        sleep(1000);
        log.info("조회 nameStore={}", nameStore.get());
        return nameStore.get(); // 객체이기때문에 메서드를 통해 값 꺼낸다
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
