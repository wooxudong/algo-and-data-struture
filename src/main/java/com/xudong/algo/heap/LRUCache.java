package com.xudong.algo.heap;


import java.util.*;

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Integer> keyValues;
    private final Queue<Pair<Long, Integer>> lruKeys;
    private final Map<Integer, Long> mrus;
    private Long now;

    public LRUCache(int i) {
        this.capacity = i;
        this.keyValues = new HashMap<>(capacity);
        this.mrus = new HashMap<>(capacity);
        this.lruKeys = new PriorityQueue<>(capacity, Comparator.comparingLong(Pair::getTime));
        this.now = 0L;
    }

    public void put(int key, int value) {
        if (keyValues.size() == capacity && !keyValues.containsKey(key)) {
            evictOneEntry();
        }
        keyValues.put(key, value);
        now += 1L;
        mrus.put(key, now);
        lruKeys.offer(new Pair<>(now, key));
    }

    private void evictOneEntry() {
        Pair<Long, Integer> lruKey = lruKeys.poll();
        while (!mrus.containsKey(lruKey.getKey())
                ||
                mrus.get(lruKey.getKey()) > (lruKey.getTime()))
            lruKey = lruKeys.poll();

        mrus.remove(lruKey.getKey());
        keyValues.remove(lruKey.getKey());
    }


    public int get(int key) {
        if (keyValues.containsKey(key)) {
            now += 1L;
            mrus.put(key, now);
            lruKeys.offer(new Pair<>(now, key));
            return keyValues.get(key);
        }
        return -1;
    }

    private static class Pair<L, I extends Number> {
        Long time;
        int key;

        Pair(Long time, int key) {
            this.time = time;
            this.key = key;
        }

        public Long getTime() {
            return time;
        }

        public int getKey() {
            return key;
        }
    }
}
