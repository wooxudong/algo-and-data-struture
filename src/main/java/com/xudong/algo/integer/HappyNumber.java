package com.xudong.algo.integer;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> cycle = new HashSet<>();
        while (!cycle.contains(n)){
            cycle.add(n);
            n = squareDigits(n);
            if(n == 1) return true;
        }
        return false;
    }

    int squareDigits(int num) {
        int res = 0;
        while (num >= 10) {
            res += Math.pow(num % 10, 2);
            num /= 10;
        }
        return res + (int) Math.pow(num, 2);
    }
}
