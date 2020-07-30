package com.xudong.algo.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestValidParenthesesTest {

    @Test
    void should0_ifEmptyInput(){
        //given
        String s = "";

        //when
        int result = new LongestValidParentheses().longestValidParentheses(s);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldReturnFullLength_ifAllValidParentheses(){
        //given
        String s = "((()))";

        //when
        int result = new LongestValidParentheses().longestValidParentheses(s);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldReturn0_ifNotAllValidParentheses(){
        //given
        String s = "((())))";

        //when
        int result = new LongestValidParentheses().longestValidParentheses(s);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldReturn4_ifAllValidParentheses(){
        //given
        String s = "()()";

        //when
        int result = new LongestValidParentheses().longestValidParentheses(s);

        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void leetCodeExample2(){
        //given
        String s = ")()())";

        //when
        int result = new LongestValidParentheses().longestValidParentheses(s);

        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void leetCodeExample1(){
        //given
        String s = "(()";

        //when
        int result = new LongestValidParentheses().longestValidParentheses(s);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void leetCodeFailedExample1(){
        //given
        String s = "()(()";

        //when
        int result = new LongestValidParentheses().longestValidParentheses(s);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void leetCodeFailedExample2(){
        //given
        String s = ")()(((())))(";

        //when
        int result = new LongestValidParentheses().longestValidParentheses(s);

        //then
        assertThat(result).isEqualTo(10);
    }
}
