package InterviewQuestions.RateLimiterLLD.factory;

import InterviewQuestions.RateLimiterLLD.limiters.FixedWindowLimiter;
import InterviewQuestions.RateLimiterLLD.limiters.RateLimiter;
import InterviewQuestions.RateLimiterLLD.limiters.SlidingWindowLogLimiter;
import InterviewQuestions.RateLimiterLLD.limiters.TokenBucketLimiter;
import InterviewQuestions.RateLimiterLLD.models.RateLimitConfig;
import InterviewQuestions.RateLimiterLLD.models.RateLimitType;

public class RateLimiterFactory {
    public static RateLimiter createRateLimiter(RateLimitType type, RateLimitConfig config) {
        RateLimiter rateLimiter = null;
        switch (type) {
            case TOKEN_BUCKET -> rateLimiter = new TokenBucketLimiter(config);
            case FIXED_WINDOW -> rateLimiter = new FixedWindowLimiter(config);
            case SLIDING_WINDOW_LOG -> rateLimiter = new SlidingWindowLogLimiter(config);
            default -> throw new IllegalArgumentException("Invalid rate limiter type: " + type);
        }
        return rateLimiter;
    }
}
