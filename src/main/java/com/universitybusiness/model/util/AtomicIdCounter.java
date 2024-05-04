package com.universitybusiness.model.util;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicIdCounter {
    private static final AtomicLong counter = new AtomicLong(0);

    public static void setCounter(long value) {
        counter.set(value);
    }
    public static long nextId() {
        return counter.incrementAndGet();
    }
}
