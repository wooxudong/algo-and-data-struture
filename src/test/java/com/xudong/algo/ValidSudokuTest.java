package com.xudong.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidSudokuTest {

    @Test
    void validSudoku() {
        char[][] input = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        //when
        boolean isValid = new ValidSudoku().isValidSudoku(input);

        //then
        assertThat(isValid).isTrue();
    }


    @Test
    void inValidSudoku() {
        char[][] input = new char[][]{
                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        //when
        boolean isValid = new ValidSudoku().isValidSudoku(input);

        //then
        assertThat(isValid).isFalse();
    }

    @Test
    void failedCase() {
        char[][] board = new char[][]{
                new char[]{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                new char[]{'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                new char[]{'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                new char[]{'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                new char[]{'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                new char[]{'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '4', '.', '.', '.', '.', '.', '.'}};

        //when
        boolean isValid = new ValidSudoku().isValidSudoku(board);

        //then
        assertThat(isValid).isFalse();

    }
}

