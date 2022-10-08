package com.xudong.algo.string;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String last = countAndSay(n-1);
        return say(last);
    }

    private String say(String last) {
        char[] digits = last.toCharArray();
        StringBuilder result = new StringBuilder();
        int index = 0;
        while(index < digits.length){
            char current = digits[index];
            int count = 0;
            while(index < digits.length && current == digits[index]) {
                count ++;
                index ++;
            }
            result.append(count);
            result.append(current);
        }
        return result.toString();
    }
}
