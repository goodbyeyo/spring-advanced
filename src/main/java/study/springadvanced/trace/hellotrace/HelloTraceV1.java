package study.springadvanced.trace.hellotrace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.springadvanced.trace.TraceId;
import study.springadvanced.trace.TraceStatus;

@Slf4j
@Component  // 컴포넌트 스캔 대상 -> 자동으로 스프링 빈으로 등록된
public class HelloTraceV1 {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    // 로그 메세지를 파라미터로 받아서 시작로그 추력
    public TraceStatus begin(String message) {
        TraceId traceId = new TraceId();
        Long startTimeMs = System.currentTimeMillis();
        // 로그 출력
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX,
                traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);

    }

    //
    public void end(TraceStatus status) {
        complete(status, null);
    }
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }
    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(),
                    addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(),
                    resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
                    addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
                    e.toString());
        }
    }
    private static String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append( (i == level - 1) ? "|" + prefix : "| ");
        }
        return sb.toString();
    }
//    prefix: -->
//       level 0:
//       level 1: |-->
//       level 2: |   |-->
//    prefix: <--
//       level 0:
//       level 1: |<--
//       level 2: |   |<--
//    prefix: <X-
//       level 0:
//       level 1: |<X-
//       level 2: |   |<X-
}
