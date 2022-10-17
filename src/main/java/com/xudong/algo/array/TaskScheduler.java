package com.xudong.algo.array;


import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        else {
            HashMap<Character, Integer> counts = new HashMap<>();
            for (char task : tasks) {
                if (counts.containsKey(task)) counts.put(task, counts.get(task) + 1);
                else counts.put(task, 1);
            }

            Comparator<Map.Entry<Character, Integer>> entryComparator = Comparator.comparingInt(Map.Entry::getValue);
            Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(entryComparator.reversed());
            counts.entrySet().forEach(pq::add);
            Map.Entry<Character, Integer> maxCounts = pq.poll();
            int idles = (maxCounts.getValue() - 1) * n;
            while (!pq.isEmpty()) {
                Map.Entry<Character, Integer> next = pq.poll();
                if (next.getValue() == maxCounts.getValue()) {
                    idles += 1;
                }
            }
            return Math.max(tasks.length, maxCounts.getValue() + idles);
        }
    }
}
