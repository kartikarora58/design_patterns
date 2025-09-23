package RateLimiter;
import java.util.concurrent.ConcurrentHashMap;

// in token bucket algorithm
// we can use a separate thread to refill the bucket
// but we use lazy refill
// we use the last fill time, to calculate the tokens
// because excess tokens will be rejected by the bucket
// in this way there is efficient utilization of the resources
public class UserTokenBucket {

    private static class TokenBucket {
        private final int capacity;
        private final int refillRate;
        private double tokens;
        private long lastRefillTimestamp;

        public TokenBucket(int capacity, int refillRate) {
            this.capacity = capacity;
            this.refillRate = refillRate;
            this.tokens = capacity;
            this.lastRefillTimestamp = System.currentTimeMillis();
        }

        // Lazy refill
        private synchronized void refill() {
            long now = System.currentTimeMillis();
            double secondsPassed = (now - lastRefillTimestamp) / 1000.0;
            double tokensToAdd = secondsPassed * refillRate;
            if (tokensToAdd > 0) {
                tokens = Math.min(capacity, tokens + tokensToAdd);
                lastRefillTimestamp = now;
            }
        }

        public synchronized boolean tryConsume() {
            refill();
            if (tokens >= 1) {
                tokens -= 1;
                return true;
            } else {
                return false;
            }
        }

        public synchronized double getTokens() {
            refill();
            return tokens;
        }
    }

    private final ConcurrentHashMap<String, TokenBucket> userBuckets = new ConcurrentHashMap<>();
    private final int capacity;
    private final int refillRate;

    public UserTokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    public boolean tryConsume(String userId) {
        TokenBucket bucket = userBuckets.computeIfAbsent(userId, id -> new TokenBucket(capacity, refillRate));
        return bucket.tryConsume();
    }

    public double getTokens(String userId) {
        TokenBucket bucket = userBuckets.get(userId);
        return bucket == null ? capacity : bucket.getTokens();
    }

    // Example usage
    public static void main(String[] args) throws InterruptedException {
        UserTokenBucket limiter = new UserTokenBucket(5, 2); // 5 tokens max, refill 2/sec

        Runnable task = () -> {
            String user = "user1";
            if (limiter.tryConsume(user)) {
                System.out.println(Thread.currentThread().getName() + " consumed a token. Tokens left: " + limiter.getTokens(user));
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to consume token.");
            }
        };

        // Simulate multi-threaded requests
        for (int i = 0; i < 20; i++) {
            new Thread(task).start();
            Thread.sleep(200);
        }
    }
}
