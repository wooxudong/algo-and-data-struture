package com.xudong.algo.string;

import java.util.Map;
import java.util.Objects;

enum SEVERITY {
    NOSEV,
    ONE,
    TWO,
    THREE
}

/*
Since today is April's Fools day, TWers suspect that there are fake news about TW. They know that the news is false if it contains any of the string(s) "unreadable/messy/badcode/lone" as a subsequence. Help TWers determine whether this piece of news is true.
INPUT : The first and only line contains a non-empty string s of length no greater than 1000, consisting of lowercase letters of Latin alphabet (a-z).
OUTPUT : Output the different SEV level based on the sum of the weighted number of unique occurrence of the string(s) "unreadable/messy/badcode/lone" as a subsequence. If none, output NOSEV
 */
public class AprilFoolDayChallenge {
    private final String BARCODE = "barcode";
    private final String MESSY = "messy";
    private final String UNREADABLE = "unreadable";
    private final String LONE = "lone";
    private final String TDD = "tdd";
    private final String PAIRING = "pairing";
    private final String AGILE = "agile";
    private final Map<String, Integer> WEIGHTAGE = Map.of(
            BARCODE, 2,
            MESSY, 1,
            UNREADABLE, 1,
            LONE, 2,
            TDD, -1,
            PAIRING, -1,
            AGILE, -1
    );

    public SEVERITY process(String input) {
        if (Objects.isNull(input) || input.trim().length() == 0) return SEVERITY.NOSEV;
        int sum = 0;

        for (String key : WEIGHTAGE.keySet()) {
            sum += getWeightageForTargetOrZero(input, key);
        }

        return mapToSeverity(sum);
    }

    private SEVERITY mapToSeverity(int sum) {

        if (sum == 1) {
            return SEVERITY.THREE;
        } else if (sum == 2) {
            return SEVERITY.TWO;
        } else if (sum >= 3) {
            return SEVERITY.ONE;
        } else {
            return SEVERITY.NOSEV;
        }

    }


    private int getWeightageForTargetOrZero(String main, String target) {
        char[] mainChars = main.toCharArray();
        char[] targetChars = target.toCharArray();
        int mainPointer = 0;
        int targetPointer = 0;
        while (mainPointer < main.length() && targetPointer < target.length()) {
            if (mainChars[mainPointer] == targetChars[targetPointer]) {
                targetPointer++;
            }
            mainPointer++;
        }
        return targetPointer == target.length() ? WEIGHTAGE.get(target) : 0;
    }


}
