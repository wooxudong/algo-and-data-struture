package com.xudong.algo.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GasStationTest {

    @Test
    void shouldCompleteCircle(){
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};

        int station = new GasStation().canCompleteCircuit(gas, cost);

        assertThat(station).isEqualTo(3);
    }

    @Test
    void cantComplete(){
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};

        int station = new GasStation().canCompleteCircuit(gas, cost);

        assertThat(station).isEqualTo(-1);
    }

}