package com.xudong.algo.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string,
 * find the number of pairs of substrings of the string that are anagrams of each other.
 * Sample Input 0
 * abba
 * abcd
 *
 * Sample Output 0
 * 4
 * 0
 *
 * @author wooxudong
 */
public class SherlockAndAnagrams {
    public int sherlockAndAnagrams(String input) {
        if (input == null || input.length() <= 1) return 0;
        Map<String, Integer> anagrams = new HashMap<>();
        int pairs = 0;
        for (int length = 1; length < input.length(); length++) {
            for (int start = 0; start <= input.length() - length; start++) {
                String substring = input.substring(start, start + length);
                String key = sortString(substring);
                if (anagrams.containsKey(key)) {
                    pairs += anagrams.get(key);
                    anagrams.put(key, anagrams.get(key) + 1);
                } else {
                    anagrams.put(key, 1);
                }
            }
            //after the first iteration, if all char are unique, just return 0;
            if(length == 1 && pairs == 0) return 0;
        }
        return pairs;
    }

    private String sortString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
}
