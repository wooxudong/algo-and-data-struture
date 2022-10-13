package com.xudong.algo.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MultiplyStringTest {
    @Test
    void test() {
        assertThat(new MultiplyStrings().multiply("2", "3")).isEqualTo("6");
    }
}
