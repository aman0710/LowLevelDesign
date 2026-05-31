package InterviewQuestions.RateLimiterLLD.service;

import InterviewQuestions.RateLimiterLLD.factory.RateLimiterFactory;
import InterviewQuestions.RateLimiterLLD.limiters.RateLimiter;
import InterviewQuestions.RateLimiterLLD.models.RateLimitConfig;
import InterviewQuestions.RateLimiterLLD.models.RateLimitType;
import InterviewQuestions.RateLimiterLLD.models.User;
import InterviewQuestions.RateLimiterLLD.models.UserTier;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {
    private final Map<UserTier, RateLimiter> rateLimiterMap = new HashMap<>();

    public RateLimiterService() {
        rateLimiterMap.put(UserTier.FREE, RateLimiterFactory.createRateLimiter(RateLimitType.TOKEN_BUCKET, new RateLimitConfig(60, 10)));
        rateLimiterMap.put(UserTier.PREMIUM, RateLimiterFactory.createRateLimiter(RateLimitType.FIXED_WINDOW, new RateLimitConfig(60, 100)));
    }

    public boolean allowRequests(User user) {
        RateLimiter rateLimiter = rateLimiterMap.get(user.getUserTier());
        if(rateLimiter == null)
            throw new IllegalArgumentException("No rate limiter configured for user tier: " + user.getUserTier());
        return rateLimiter.allowRequest(user.getUserId());
    }
}
