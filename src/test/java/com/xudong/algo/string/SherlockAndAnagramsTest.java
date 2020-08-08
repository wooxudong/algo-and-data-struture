package com.xudong.algo.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SherlockAndAnagramsTest {

    @Test
    void shouldReturn0_ifInputIsNullOrEmpty(){
        //given
        String input = null;

        //when
       int pairs =  new SherlockAndAnagrams().sherlockAndAnagrams(input);

       //then
        assertThat(pairs).isEqualTo(0);
    }

    @Test
    void shouldReturn0_ifInputHasLengthOne(){
        //given
        String input = "a";

        //when
        int pairs =  new SherlockAndAnagrams().sherlockAndAnagrams(input);

        //then
        assertThat(pairs).isEqualTo(0);
    }

    @Test
    void shouldReturn1_ifInputIsTwoSameChar(){
        //given
        String input = "aa";

        //when
        int pairs =  new SherlockAndAnagrams().sherlockAndAnagrams(input);

        //then
        assertThat(pairs).isEqualTo(1);
    }

    @Test
    void hackerrank_example1(){
        //given
        String input = "abba";

        //when
        int pairs =  new SherlockAndAnagrams().sherlockAndAnagrams(input);

        //then
        assertThat(pairs).isEqualTo(4);
    }

    @Test
    void hackerrank_example2(){
        //given
        String input = "llll";

        //when
        int pairs =  new SherlockAndAnagrams().sherlockAndAnagrams(input);

        //then
        assertThat(pairs).isEqualTo(10);
    }
}
