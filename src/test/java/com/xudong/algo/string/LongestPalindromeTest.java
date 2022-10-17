package com.xudong.algo.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LongestPalindromeTest {
    @Test
    void shouldReturnZeroForEmptyAndOneElement(){

        int length = new LongestPalindrome().longestPalindrome(new String[]{"lc"});

        assertThat(length).isEqualTo(0);
    }

    @Test
    void shouldReturnLengthIfThereIsPalindrome(){
        int length = new LongestPalindrome().longestPalindrome(new String[]{"lc","cl","gg"});

        assertThat(length).isEqualTo(6);
    }

    @Test
    void shouldReturnLengthIfThereIsPalindrome2(){
        int length = new LongestPalindrome().longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"});

        assertThat(length).isEqualTo(8);
    }

    @Test
    void shouldReturnLengthIfThereIsPalindrome3(){
        int length = new LongestPalindrome().longestPalindrome(new String[]{"cc", "ll", "xx"});

        assertThat(length).isEqualTo(2);
    }

    @Test
    void shouldReturnLengthIfThereIsPalindrome4(){
        int length = new LongestPalindrome().longestPalindrome(new String[]{"cc", "ll", "cc"});

        assertThat(length).isEqualTo(6);
    }

    @Test
    void shouldReturnLengthIfThereIsPalindrome5(){
        int length = new LongestPalindrome().longestPalindrome(new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"});

        assertThat(length).isEqualTo(22);
    }

    @Test
    void shouldReturnLengthIfThereIsPalindrome6(){
        int length = new LongestPalindrome().longestPalindrome(new String[]{"em","pe","mp","ee","pp","me","ep","em","em","me"});

        assertThat(length).isEqualTo(14);
    }
}