package RateLimiter;

public class LeakyBucket {
    private final int capacity;     // Max number of requests the bucket can hold
    private final double leakRate;  // Requests processed per second
    private double water;           // Current number of requests in the bucket
    private long lastCheckTime;     // Timestamp of last leak check in milliseconds

    public LeakyBucket(int capacity, double leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.water = 0;
        this.lastCheckTime = System.currentTimeMillis();
    }

    // Thread-safe method to check if a request can be allowed
    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        double elapsedSeconds = (now - lastCheckTime) / 1000.0;

        // Leak water based on elapsed time
        water = Math.max(0, water - elapsedSeconds * leakRate);
        lastCheckTime = now;

        if (water < capacity) {
            water++; // Accept request
            return true;
        } else {
            return false; // Reject request (bucket full)
        }
    }

    public synchronized double getCurrentWaterLevel() {
        return water;
    }
}
