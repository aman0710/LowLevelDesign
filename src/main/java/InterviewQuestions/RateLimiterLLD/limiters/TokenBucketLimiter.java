package InterviewQuestions.RateLimiterLLD.limiters;

import InterviewQuestions.RateLimiterLLD.models.RateLimitConfig;
import InterviewQuestions.RateLimiterLLD.models.RateLimitType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TokenBucketLimiter extends RateLimiter {

    private Map<String, Integer> tokens = new ConcurrentHashMap<>();
    private Map<String, Long> lastRefillTime = new HashMap<>();

    public TokenBucketLimiter(RateLimitConfig config) {
        super(config, RateLimitType.TOKEN_BUCKET);
    }

    @Override
    public boolean allowRequest(String userId) {
        AtomicBoolean allowed = new AtomicBoolean(false);
        long now = System.currentTimeMillis();

        tokens.compute(userId, (id, availableTokens) -> {
            int currentTokens = refillTokens(userId, now);

            if(currentTokens > 0) {
                allowed.set(true);
                return currentTokens - 1;
            } else
                return currentTokens;
        });
        return allowed.get();
    }

    private int refillTokens(String userId, long now) {
        int refillRate = config.getWindowInSeconds() / config.getMaxRequests();

        long elapsedTime = (now - lastRefillTime.getOrDefault(userId, now)) / 1000;
        int addedTokens = (int) elapsedTime / refillRate;

        int totalTokens = tokens.getOrDefault(userId, config.getMaxRequests()) + addedTokens;
        totalTokens = Math.min(config.getMaxRequests(), totalTokens);
        if(addedTokens > 0)
            lastRefillTime.put(userId, now);

        return totalTokens;
    }
}
