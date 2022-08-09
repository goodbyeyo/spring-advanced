package study.springadvanced.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{

    // 클라이언트가 프록시를 호출하면 프록시가 최종적으로 실제 객체를 호출해야 한다
    // 따라서 내부에 실제 객체의 참조를 가지고 있어야 한다. 이렇게 프록시가 호출하는 대상을 target 이라고 한다
    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() { // 프록시도 실제 객체와 모양이 같아야 하기때문에 Subject 인터페이스를 구현
        log.info("프록시 호출");
        if (cacheValue == null) {
            cacheValue = target.operation();
        }
        return cacheValue;
    }
}
