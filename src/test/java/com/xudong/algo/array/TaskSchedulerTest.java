package com.xudong.algo.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TaskSchedulerTest {

    @Test
    void shouldReturnArrayLengthIfIntervalZero(){
        int timeUnits = new TaskScheduler().leastInterval(new char[]{'A'}, 0);

        assertThat(timeUnits).isEqualTo(1);
    }

    @Test
    void testCase1(){
        int timeUnits = new TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B'}, 2);

        assertThat(timeUnits).isEqualTo(8);
    }

    @Test
    void testCase2(){
        int timeUnits = new TaskScheduler().leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2);

        assertThat(timeUnits).isEqualTo(16);
    }
}