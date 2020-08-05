package com.xudong.algo.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrefixSumAndDifferenceTest {

    @Test
    void shouldReturnTheBiggestAfterArrayManipulation() {
        //given
        int[][] manipulations = new int[][]{
                new int[]{1, 5, 3},
                new int[]{4, 8, 7},
                new int[]{6, 9, 1}
        };

        int n = 10;

        //when
        int biggest  = new PrefixSumAndDifference().manipulateAndReturnBiggest(n, manipulations);

        //then
        assertThat(biggest).isEqualTo(10);
    }
}
