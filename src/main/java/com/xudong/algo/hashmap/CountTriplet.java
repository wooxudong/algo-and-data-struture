package com.xudong.algo.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Complete the countTriplets function in the editor below. It should return the
 * number of triplets forming a geometric progression for a given r as an integer.
 *
 * countTriplets has the following parameter(s):
 *
 * arr: an array of integers
 * r: an integer, the common ratio
 *
 * Sample Input 1
 * 6 3
 * 1 3 9 9 27 81
 *
 * Sample Output 1
 * 6
 *
 * @author wooxudong
 */
public class CountTriplet {
    public long countTriplets(List<Long> arr, int r) {
        if (r == 1) return countSameTriples(arr);
        Map<Long, Long> counts = new HashMap<>();
        Map<Long, Long> prevCounts = new HashMap<>();
        long triplets = 0L;
        for (Long ele : arr) {
            if (counts.containsKey(ele)) counts.put(ele, counts.get(ele) + 1L);
            else counts.put(ele, 1L);

            if (prevCounts.containsKey(ele)) {
                prevCounts.put(ele, prevCounts.get(ele) + counts.get(ele / r));
            } else {
                //make sure the exact divider is the counts.
                if (counts.containsKey(ele / r) && ele%r == 0L) {
                    prevCounts.put(ele, counts.get(ele / r));
                }
            }
            if (prevCounts.containsKey(ele / r) && ele%r == 0L) {
                triplets += prevCounts.get(ele / r);
            }
        }
        return triplets;
    }



    long countSameTriples(List<Long> arr) {
        Map<Long, Long> counts = new HashMap<>();
        for (Long ele : arr) {
            if (counts.containsKey(ele)) {
                counts.put(ele, counts.get(ele) + 1L);
            } else {
                counts.put(ele, 1L);
            }
        }
        return counts.keySet().stream()
                .filter(key -> counts.get(key) >= 3L)
                .map(key -> {
                    long count = counts.get(key);
                    return count * (count - 1L) * (count - 2L) / 6L;
                })
                .reduce(Long::sum).orElse(0L);
    }
}
