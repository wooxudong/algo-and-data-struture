package com.xudong.algo.array;

public class RangeSearch {
    public Pair<Integer, Integer> searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return Pair.of(-1,-1);
        return searchRangeR(nums, 0, nums.length - 1, target);
    }

    private Pair<Integer, Integer> searchRangeR(int[] nums, int low, int high, int target) {
        if (low > high) return Pair.of(-1, -1);
        int middle = low + (high - low) / 2;
        if (target == nums[middle]) {
            int first = middle, second = middle;
            while(first-1>=0 && nums[first-1] == nums[first]) first --;
            while(second+1<nums.length && nums[second+1] == nums[second]) second++;
            return Pair.of(first, second);
        }

        if (target < nums[middle]) return searchRangeR(nums, low, middle - 1, target);
        else return searchRangeR(nums, middle + 1, high, target);
    }

    public static class Pair<T1, T2> {
        public final T1 first;
        public final T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public static <T1, T2> Pair<T1, T2> of(T1 first, T2 second) {
            return new Pair<>(first, second);
        }
    }
}
