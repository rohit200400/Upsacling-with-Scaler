package Task2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class RateLimiter {

    private final Semaphore semaphore;
    private final long maxPermitsPerSecond;
    private final long periodInMillis;
    private volatile long lastRefillTime;

    public RateLimiter(long maxPermitsPerSecond) {
        this.maxPermitsPerSecond = maxPermitsPerSecond;
        this.periodInMillis = 1000 / maxPermitsPerSecond;
        this.semaphore = new Semaphore((int) maxPermitsPerSecond);
        this.lastRefillTime = System.currentTimeMillis();
    }

    public boolean acquire() throws InterruptedException {
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastRefillTime >= 1000) {
            long permitsToRefill = maxPermitsPerSecond;
            semaphore.release((int) permitsToRefill);
            lastRefillTime = currentTime;
        }

        // Try to acquire a permit with a timeout to avoid unnecessary blocking
        return semaphore.tryAcquire(20, TimeUnit.MILLISECONDS);
    }


}
