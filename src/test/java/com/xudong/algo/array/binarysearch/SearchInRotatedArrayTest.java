package com.xudong.algo.array.binarysearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchInRotatedArrayTest {

    @Test
    void shouldReturnIndex_ifNotRotated() {
        //given
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7};
        int target = 4;

        //when
        int index = new RotatedArraySearch().search(nums, 4);

        //then
        assertThat(index).isEqualTo(3);
    }

    @Test
    void shouldReturnIndex_ifNotRotated2() {
        //given
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7};

        //when
        int index = new RotatedArraySearch().search(nums, 7);

        //then
        assertThat(index).isEqualTo(6);
    }

    @Test
    void shouldReturnIndex_ifNotRotated3() {
        //given
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7};

        //when
        int index = new RotatedArraySearch().search(nums, 0);

        //then
        assertThat(index).isEqualTo(0);
    }

    @Test
    void shouldReturnMinusOne_ifNotRotated() {
        //given
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7};
        int target = 4;

        //when
        int index = new RotatedArraySearch().search(nums, 3);

        //then
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void shouldReturnMinusOne_ifRotated() {
        //given
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};

        //when
        int index = new RotatedArraySearch().search(nums, 3);

        //then
        assertThat(index).isEqualTo(-1);
    }

    @Test
    void shouldReturnIndex_ifRotated() {
        //given
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};

        //when
        int index = new RotatedArraySearch().search(nums, 6);

        //then
        assertThat(index).isEqualTo(2);
    }

    @Test
    void shouldReturnIndex_ifRotated2() {
        //given
        int[] nums = new int[]{3,1};

        //when
        int index = new RotatedArraySearch().search(nums, 1);

        //then
        assertThat(index).isEqualTo(1);
    }
}
