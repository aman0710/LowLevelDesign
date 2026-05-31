package InterviewQuestions.RateLimiterLLD.limiters;

import InterviewQuestions.RateLimiterLLD.models.RateLimitConfig;
import InterviewQuestions.RateLimiterLLD.models.RateLimitType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedWindowLimiter extends RateLimiter{

    Map<String, Integer> requestCount = new ConcurrentHashMap<>();
    Map<String, Long> windowStartTime = new HashMap<>();

    public FixedWindowLimiter(RateLimitConfig config) {
        super(config, RateLimitType.FIXED_WINDOW);
    }

    @Override
    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        AtomicBoolean allowed = new AtomicBoolean(false);
        long currentWindow = now / 1000 / config.getWindowInSeconds();

        requestCount.compute(userId, (id, count) -> {
            long lastWindow = windowStartTime.getOrDefault(id, currentWindow);
            if(lastWindow != currentWindow) {
                windowStartTime.put(id, currentWindow);
                allowed.set(true);
                return 1;
            }
            if(count == null)
                count = 0;
            if(count < config.getMaxRequests()) {
                allowed.set(true);
                return count + 1;
            }
            return count;
        });
        return allowed.get();
    }
}
