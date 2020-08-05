package com.xudong.algo.array;

/**
 * Complete the function arrayManipulation in the editor below. It must return an integer, the maximum value in the resulting array.
 *
 * arrayManipulation has the following parameters:
 *
 * n - the number of elements in your array
 * queries - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
 *
 * Sample Input
 * 5 3
 * 1 2 100
 * 2 5 100
 * 3 4 100
 *
 * Sample Output
 * 200
 *
 * This could be solved by difference array very easily!!!!
 * @author wooxudong
 */
public class PrefixSumAndDifference {

    public int manipulateAndReturnBiggest(int n, int[][] manipulations) {

        //since all value is 0 in the beginning, the prefix tree will start with all zeros.
        int[] difference = new int[n+1];

        for (int[] update : manipulations) {
            difference[update[0]] += update[2];
            difference[update[1] + 1] -= update[2];
        }

        int max = 0;
        int accumulated = 0;
        for (int i = 1; i <= n; i ++) {
            //the prefix sum for difference array is the original ai.
            accumulated += difference[i];
            max = Math.max(accumulated, max);
        }

        return max;
    }
}
