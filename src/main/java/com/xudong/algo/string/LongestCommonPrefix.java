package com.xudong.algo.string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int index = 0 ;

        while(true){
            if(index >= strs[0].length()) return result.toString();
            char target = strs[0].charAt(index);
            for (String str : strs) {
                if(index >= str.length() || str.charAt(index) != target) return result.toString();
            }
            result.append(target);
            index ++;
        }
    }
}
