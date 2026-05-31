package InterviewQuestions.RateLimiterLLD.models;

public class RateLimitConfig {
    int windowInSeconds;
    int maxRequests;

    public RateLimitConfig(int windowInSeconds, int maxRequests) {
        this.windowInSeconds = windowInSeconds;
        this.maxRequests = maxRequests;
    }

    public int getWindowInSeconds() {
        return windowInSeconds;
    }

    public void setWindowInSeconds(int windowInSeconds) {
        this.windowInSeconds = windowInSeconds;
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public void setMaxRequests(int maxRequests) {
        this.maxRequests = maxRequests;
    }
}
