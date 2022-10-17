package com.xudong.algo.string;

import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String[] words) {
        if (words.length == 0) return 0;
        else {
            HashMap<String, Integer> counts = new HashMap<>();
            int res = 0;
            int countOfSelfPalindrome = 0;

            for (String word : words) {
                if (isSelfPalindrome(word)) {
                    if (counts.containsKey(word) && counts.get(word) > 0) {
                        res += 4;
                        counts.put(word, counts.get(word) - 1);
                        countOfSelfPalindrome -= 1;
                    } else {
                        counts.put(word, 1);
                        countOfSelfPalindrome += 1;
                    }
                } else {
                    String reversed = reverse(word);
                    if (counts.containsKey(reversed) && counts.get(reversed) > 0) {
                        res += 4;
                        counts.put(reversed, counts.get(reversed) - 1);
                    } else {
                        if (counts.containsKey(word)) counts.put(word, counts.get(word) + 1);
                        else counts.put(word, 1);
                    }
                }
            }

            if (countOfSelfPalindrome > 0) res += 2;
            return res;

        }
    }


    String reverse(String str) {
        return String.valueOf(new char[]{str.charAt(1), str.charAt(0)});
    }

    boolean isSelfPalindrome(String str) {
        return str.charAt(0) == str.charAt(1);
    }
}
