package com.xudong.algo.integer;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) return -dividend;
            return Integer.MAX_VALUE;
        }
        Boolean isNegative = isNegative(dividend, divisor);
        long dividendA = Math.abs((long) dividend);
        long divisorA = Math.abs((long) divisor);

        int result = 0;
        while (dividendA >= divisorA) {
            int shift = 0;
            while (dividendA >= (divisorA << shift)) {
                shift += 1;
            }
            result += 1 << (shift - 1);
            dividendA = dividendA - (divisorA << (shift - 1));
        }

        return isNegative ? -result : result;
    }

    public Boolean isNegative(int dividend, int divisor) {
        return (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
    }
}
