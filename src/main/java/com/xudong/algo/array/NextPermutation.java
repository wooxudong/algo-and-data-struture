package com.xudong.algo.array;

import java.util.Arrays;

/**
 * Leetcode - 31
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author wooxudong
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {

        int length = nums.length;
        int cursor = length - 1;
        //find the first index from the back that is smaller than the current
        while (cursor - 1 >= 0 && nums[cursor - 1] >= nums[cursor]) cursor--;

        if (cursor == 0) {
            for(int i = 0; i < length / 2; i++){
                swap(nums, i, length-1-i);
            }
        } else {
            int toSwap = findNextLarger(nums, nums[cursor-1], cursor);
            swap(nums, cursor-1, toSwap);
            Arrays.sort(nums, cursor, length);
        }
    }

    private int findNextLarger(int[] nums, int target, int current) {
        while(current + 1 < nums.length && nums[current+1] > target) current ++;
        return current;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
