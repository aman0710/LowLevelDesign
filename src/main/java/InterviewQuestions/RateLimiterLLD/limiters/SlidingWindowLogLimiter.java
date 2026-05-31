package InterviewQuestions.RateLimiterLLD.limiters;

import InterviewQuestions.RateLimiterLLD.models.RateLimitConfig;
import InterviewQuestions.RateLimiterLLD.models.RateLimitType;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class SlidingWindowLogLimiter extends RateLimiter{

    Map<String, Queue<Long>> requestLog = new ConcurrentHashMap<>();

    public SlidingWindowLogLimiter(RateLimitConfig config) {
        super(config, RateLimitType.SLIDING_WINDOW_LOG);
    }

    @Override
    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        AtomicBoolean allowed = new AtomicBoolean(false);

        requestLog.compute(userId, (id, log) -> {
            if(log == null)
                log = new ArrayDeque<>();
            while(!log.isEmpty() && (now - log.peek()) / 1000 > config.getWindowInSeconds())
                log.poll();
            if(log.size() < config.getMaxRequests()) {
                allowed.set(true);
                log.add(now);
            }
            return log;
        });
        return allowed.get();
    }
}
