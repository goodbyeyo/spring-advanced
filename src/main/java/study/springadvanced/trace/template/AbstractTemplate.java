package study.springadvanced.trace.template;

import study.springadvanced.trace.TraceStatus;
import study.springadvanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    // Type 정보를 객체를 생성하는 시점으로 미룬다 - return type 정의 : <T>
    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            // 로직 호출
            T result = call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
