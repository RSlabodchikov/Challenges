package com.slabodchikov.challenges;

import java.net.http.HttpRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Roman Slabodchikov on 3/21/2023
 */
public class RateLimiter {

    private static final Map<Integer, Long> transactions = new ConcurrentHashMap<>();
    private final Long threshold;

    public RateLimiter(Long threshold) {
        this.threshold = threshold;
    }

    public boolean evaluate(HttpRequest request) {
        if (transactions.size() >= threshold) {
            return false;
        }
        long currentTime = System.currentTimeMillis();
        transactions.put(request.hashCode(), currentTime);
        return true;
    }

    public void releaseTransaction(HttpRequest request) {
        long currentTime = System.currentTimeMillis();
        long startTime = transactions.remove(request.hashCode());
        long txTime = currentTime - startTime;
    }
}
