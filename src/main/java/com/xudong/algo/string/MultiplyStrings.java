package com.xudong.algo.string;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplyStrings {


    public String multiply(String num1, String num2) {
        if (num2.equals("0") || num1.equals("0")) return "0";
        ArrayList<String> interim = new ArrayList<>();

        char[] charArray1 = num1.toCharArray();
        char[] charArray2 = num2.toCharArray();
        for (int i = charArray1.length - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder temp = new StringBuilder();
            char multiplier = charArray1[i];
            for (int j = charArray2.length - 1; j >= 0; j--) {
                int tempRes = num(charArray2[j]) * num(multiplier) + carry;
                carry = tempRes / 10;
                temp.append(tempRes % 10);
            }
            if (carry != 0) temp.append(carry);
            char[] postZeros = new char[charArray1.length - 1 - i];
            Arrays.fill(postZeros, '0');
            temp.reverse().append(postZeros);
            interim.add(temp.toString());
        }
        StringBuilder res = new StringBuilder();
        int pol = 0;
        int carry = 0;
        while (pol < interim.get(interim.size() - 1).length()) {
            int temp = carry;
            for (String s : interim) {
                if (pol < s.length()) temp += num(s.charAt(s.length() - 1 - pol));
            }
            res.append(temp % 10);
            carry = temp / 10;
            pol++;
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }

    int num(char c) {
        return c - '0';
    }
}
