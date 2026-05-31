package InterviewQuestions.RateLimiterLLD;

import InterviewQuestions.RateLimiterLLD.models.User;
import InterviewQuestions.RateLimiterLLD.models.UserTier;
import InterviewQuestions.RateLimiterLLD.service.RateLimiterService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        User user1 = new User("user1", UserTier.FREE);
        User user2 = new User("user2", UserTier.PREMIUM);
        RateLimiterService rateLimiterService = new RateLimiterService();

        System.out.println("==== Free User Requests ====");
        for(int i=0; i<15; i++) {
            boolean allowed = rateLimiterService.allowRequests(user1);
            System.out.println("Request: " + (i+1) + " for FREE user: " + (allowed ? "ALLOWED" : "BLOCKED"));
            Thread.sleep(100);
        }

        System.out.println("==== Premium User Requests =====");
        for(int i=0; i<120; i++) {
            boolean allowed = rateLimiterService.allowRequests(user2);
            System.out.println("Request: " + (i+1) + " for PREMIUM user: " + (allowed ? "ALLOWED" : "BLOCKED"));
            Thread.sleep(100);
        }
    }
}
