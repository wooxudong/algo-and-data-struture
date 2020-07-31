package com.xudong.algo.array;

import com.xudong.algo.array.RangeSearch.Pair;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class searchRangeTest {

    @Test
    void shouldReturnSameIndex_ifNoRepeated(){
        //given
        int[] nums = new int[]{1,2,3,4,5,6};

        //when
        Pair<Integer, Integer> range = new RangeSearch().searchRange(nums, 3);

        assertThat(range.first).isEqualTo(2);
        assertThat(range.second).isEqualTo(2);
    }

    @Test
    void shouldReturnDifferentIndex_ifRepeatedExists(){
        //given
        int[] nums = new int[]{1,2,3,3,3,4,5,6};

        //when
        Pair<Integer, Integer> range = new RangeSearch().searchRange(nums, 3);

        assertThat(range.first).isEqualTo(2);
        assertThat(range.second).isEqualTo(4);
    }

    @Test
    void shouldReturnDifferentIndex_ifRepeatedExists2(){
        //given
        int[] nums = new int[]{1,1,2};

        //when
        Pair<Integer, Integer> range = new RangeSearch().searchRange(nums, 1);

        assertThat(range.first).isEqualTo(0);
        assertThat(range.second).isEqualTo(1);
    }
}
