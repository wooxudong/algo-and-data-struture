package com.xudong.algo.array.binarysearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * @author wooxudong
 */
public class RotatedArraySearch {
    public int search(int[] nums, int target) {
       return binarySearchR(nums, 0, nums.length-1, target);
    }


    private int binarySearchR(int[] nums, int low, int high, int target) {
        if(low > high) return -1;
        int middle = low + (high - low) / 2;
        if(target == nums[middle]){
            return middle;
        }
        if(nums[low] <= nums[middle]){
            if(target >= nums[low] && target < nums[middle]) return binarySearchR(nums, low, middle-1, target);
            else return binarySearchR(nums, middle+1, high, target);
        }else{
            if(target > nums[middle] && target <= nums[high]) return binarySearchR(nums, middle+1, high, target);
            else return  binarySearchR(nums, low, middle-1, target);
        }
    }

}
