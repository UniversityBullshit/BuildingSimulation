package com.universitybullshit.model;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicIdCounter {
    private static final AtomicLong counter = new AtomicLong(0);
    public static long nextId() {
        return counter.incrementAndGet();
    }
}
