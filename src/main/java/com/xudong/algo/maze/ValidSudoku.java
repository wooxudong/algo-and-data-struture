package com.xudong.algo.maze;

/**
 * Leetcode-36: Valid Sudoku
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *  1. Each row must contain the digits 1-9 without repetition.
 *  2. Each column must contain the digits 1-9 without repetition.
 *  3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * @author wooxudong
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null) return false;
        for (int i = 0; i < board[0].length; i++) {
            if (!checkColumn(board, i) || !checkRow(board, i) || !checkSubBox(board, i)) return false;
        }
        return true;
    }

    boolean checkColumn(char[][] board, int index) {
        int isValid = 0;
        for (int i = 0; i < board[0].length; i++) {
            char ch = board[i][index];
            if (ch != '.') {
                int mask = 1 << (ch - '0');
                if ((mask & isValid) != 0) return false;
                else isValid |= mask;
            }
        }
        return true;
    }

    boolean checkRow(char[][] board, int index) {
        int isValid = 0;
        for (char c : board[index]) {
            if (c != '.') {
                int mask = 1 << (c - '0');
                if ((mask & isValid) != 0) return false;
                else isValid |= mask;
            }
        }
        return true;
    }

    boolean checkSubBox(char[][] board, int index) {
        int startRow = index / 3 * 3;
        int startColumn = (index % 3) * 3;
        int isValid = 0;
        for (int r = startRow; r <= startRow + 2; r++) {
            for (int c = startColumn; c <= startColumn + 2; c++) {
                char ch = board[r][c];
                if (ch != '.') {
                    int mask = 1 << (ch - '0');
                    if ((mask & isValid) != 0) return false;
                    else isValid |= mask;
                }
            }
        }
        return true;
    }
}
