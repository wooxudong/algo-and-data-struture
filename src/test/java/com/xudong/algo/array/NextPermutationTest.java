package com.xudong.algo.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextPermutationTest {

    @Test
    void shouldReturnNextGreaterPermuation(){
        //give
        int[] nums = new int[]{1,2,3};

        //when
        new NextPermutation().nextPermutation(nums);

        //then
        assertThat(nums).containsExactly(1,3,2);
    }

    @Test
    void shouldFlexilyReturnNextGreaterPermuation(){
        //give
        int[] nums = new int[]{1,1,5};

        //when
        new NextPermutation().nextPermutation(nums);

        //then
        assertThat(nums).containsExactly(1,5,1);
    }

    @Test
    void shouldReturnSmallest_ifAlreadyBiggest(){
        //give
        int[] nums = new int[]{9,7,6,5};

        //when
        new NextPermutation().nextPermutation(nums);

        //then
        assertThat(nums).containsExactly(5,6,7,9);
    }

    @Test
    void shouldReturnNextBiggest_ifAlreadyBiggest(){
        //give
        int[] nums = new int[]{1,3,2};

        //when
        new NextPermutation().nextPermutation(nums);

        //then
        assertThat(nums).containsExactly(2,1,3);
    }

}