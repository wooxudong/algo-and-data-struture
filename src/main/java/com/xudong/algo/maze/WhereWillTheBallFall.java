package com.xudong.algo.maze;

public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int columnNum = grid[0].length;

        int [] result = new int[columnNum];
        for(int i = 0; i< columnNum; i ++){
           int column = fall(grid, i);
           result[i] = column;
        }
        return result;
    }

    private int fall(int[][] grid, int start) {
        int row = 0; int col = start;
        int columnNum = grid[0].length;
        int rowNum = grid.length;
        int result = -1;
        while(row < rowNum && col < columnNum){
            if(grid[row][col] == 1){
                if (col == columnNum-1 || grid[row][col+1] == -1) return -1;
                else if( row == rowNum -1 && grid[row][col+1] == 1) return col + 1;
                else{
                    row ++;
                    col ++;
                }
            }else{
                if (col == 0 || grid[row][col -1] == 1) return -1;
                else if (row == rowNum -1 && grid[row][col-1] == -1) return col -1;
                else{
                    row ++;
                    col --;
                }
            }
        }
        return result;
    }
}
