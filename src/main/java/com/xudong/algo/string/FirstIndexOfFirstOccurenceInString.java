package com.xudong.algo.string;

public class FirstIndexOfFirstOccurenceInString {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        int start = 0;
        int end = needle.length();
        while (end <= haystack.length()) {
            String sub = haystack.substring(start, end);
            if (sub.equals(needle)) return start;
            else {
                start += 1;
                end += 1;
            }
        }
        return -1;
    }
}
