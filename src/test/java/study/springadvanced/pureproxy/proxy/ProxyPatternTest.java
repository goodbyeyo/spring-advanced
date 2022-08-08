package study.springadvanced.pureproxy.proxy;

import org.junit.jupiter.api.Test;
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
}
