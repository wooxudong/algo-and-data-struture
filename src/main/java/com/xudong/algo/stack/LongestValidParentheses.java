package com.xudong.algo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        Deque<Integer> parentheses = new ArrayDeque<>();
        char[] fragments = s.toCharArray();
        int[] valid = new int[s.length()];
        for (int i = 0; i < fragments.length; i++) {
            if (fragments[i] == '(') {
                parentheses.addFirst(i);
            } else if (fragments[i] == ')') {
                if (parentheses.size() != 0) {
                    valid[parentheses.pollFirst()] = 1;
                    valid[i] = 1;
                }
            }
        }
        return  findLongestConsecutiveOnes(valid);
    }

    private int findLongestConsecutiveOnes(int[] valid) {
        int max = 0, currMax = 0, cursor = 0;
        while(cursor < valid.length){
            while(cursor < valid.length && valid[cursor] == 1) {
                currMax +=1;
                cursor ++;
            }
            max = Math.max(currMax, max);
            currMax = 0;
            cursor++;
        }
        return max;
    }
}
