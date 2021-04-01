package com.xudong.algo.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AprilFoolDayChallengeTest {

    @Test
    public void shouldReturnNoSevInputNull(){
        //given
        String input = null;

        //when
        SEVERITY ouput = new AprilFoolDayChallenge().process(input);

        //then
        assertThat(ouput).isEqualTo(SEVERITY.NOSEV);
    }

    @Test
    public void shouldReturnNoSevInputEmpty(){
        //given
        String input = "  ";

        //when
        SEVERITY ouput = new AprilFoolDayChallenge().process(input);

        //then
        assertThat(ouput).isEqualTo(SEVERITY.NOSEV);
    }

    @Test
    public void shouldReturnSev3IfInputMessey(){
        //given
        String input = "messy";

        //when
        SEVERITY output = new AprilFoolDayChallenge().process(input);

        //then
        assertThat(output).isEqualTo(SEVERITY.THREE);
    }

    @Test
    public void shouldReturnSev2IfInputBarcode(){
        //given
        String input = "barcode";

        //when
        SEVERITY output = new AprilFoolDayChallenge().process(input);

        //then
        assertThat(output).isEqualTo(SEVERITY.TWO);
    }

    @Test
    public void shouldReturnSev2IfInputBarcodeinSubsequence(){
        //given
        String input = "badarcode";

        //when
        SEVERITY output = new AprilFoolDayChallenge().process(input);

        //then
        assertThat(output).isEqualTo(SEVERITY.TWO);
    }

    @Test
    public void shouldReturnSev1IfInputIsExample1(){
        //given
        String input = "thoughtworkslikestowritemessycodeandcantidentifycodesmell";

        //when
        SEVERITY output = new AprilFoolDayChallenge().process(input);

        //then
        assertThat(output).isEqualTo(SEVERITY.TWO);
    }

    @Test
    public void shouldReturnSev2IfInputIsExample2(){
        //given
        String input = "thoughtworkslikestoworkaloneandsleep";

        //when
        SEVERITY output = new AprilFoolDayChallenge().process(input);

        //then
        assertThat(output).isEqualTo(SEVERITY.TWO);
    }

    @Test
    public void shouldReturnNoSEVIfInputIsExample3(){
        //given
        String input = "thoughtworkerswritegoodcode";

        //when
        SEVERITY output = new AprilFoolDayChallenge().process(input);

        //then
        assertThat(output).isEqualTo(SEVERITY.NOSEV);
    }

}
