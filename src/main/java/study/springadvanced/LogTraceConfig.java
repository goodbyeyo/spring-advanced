package study.springadvanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import study.springadvanced.trace.logtrace.FieldLogTrace;
import study.springadvanced.trace.logtrace.LogTrace;
import study.springadvanced.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
//        return new FieldLogTrace();
    }
}
