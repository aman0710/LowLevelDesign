package InterviewQuestions.RateLimiterLLD.limiters;

import InterviewQuestions.RateLimiterLLD.models.RateLimitConfig;
import InterviewQuestions.RateLimiterLLD.models.RateLimitType;

public abstract class RateLimiter {
    public final RateLimitConfig config;
    public final RateLimitType type;

    public RateLimiter(RateLimitConfig config, RateLimitType type) {
        this.config = config;
        this.type = type;
    }

    public abstract boolean allowRequest(String userId);
}
