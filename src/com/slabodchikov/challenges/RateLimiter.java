package com.slabodchikov.challenges;

import java.net.http.HttpRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Roman Slabodchikov
 */
public class RateLimiter {

    private final Map<Integer, Long> transactions = new ConcurrentHashMap<>();
    private final Long threshold;

    public RateLimiter(Long threshold) {
        this.threshold = threshold;
    }

    public boolean evaluate(HttpRequest request) {
        if (transactions.size() >= threshold) {
            return false;
        }
        transactions.put(request.hashCode(), System.currentTimeMillis());
        return true;
    }

    public void releaseTransaction(HttpRequest request) {
        transactions.remove(request.hashCode());
    }
}
