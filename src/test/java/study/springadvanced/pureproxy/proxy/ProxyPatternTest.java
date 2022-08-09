package study.springadvanced.pureproxy.proxy;

import org.junit.jupiter.api.Test;
import study.springadvanced.pureproxy.proxy.code.CacheProxy;
import study.springadvanced.pureproxy.proxy.code.ProxyPatternClient;
import study.springadvanced.pureproxy.proxy.code.RealSubject;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() { // OCP, DI 를 지키면서
        RealSubject realSubject = new RealSubject();
        // cacheProxy -> realSubject 참조하는 런타임 객체 의존관계
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        // client에 realSubject가 아닌 cacheProxy를 주입
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy); // client -> cacheProxy -> realSubject
        client.execute();
        client.execute();
        client.execute();
    }
}
