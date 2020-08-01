package com.xudong.algo.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SockMerchantTest {

    @Test
    void validCase(){
        int[] ar = new int[]{1,2,1,2,1,3,2};
        int n = 7;

        //when
        int pairs = new SockMerchant().sockMerchant(n, ar);

        //then˚
        assertThat(pairs).isEqualTo(2);

    }
}