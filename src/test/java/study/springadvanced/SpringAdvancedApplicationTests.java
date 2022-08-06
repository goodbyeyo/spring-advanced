package study.springadvanced;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import study.springadvanced.trace.TraceStatus;
import study.springadvanced.trace.hellotrace.HelloTraceV1;

@SpringBootTest
class SpringAdvancedApplicationTests {

	@Test
	void contextLoads() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("hello");
		trace.end(status);
	}

	@Test
	void begin_exception() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("hello");
		trace.exception(status, new IllegalStateException());
	}

}
