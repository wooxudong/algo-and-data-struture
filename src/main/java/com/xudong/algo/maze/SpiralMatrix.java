package com.xudong.algo.maze;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length + 2][matrix[0].length + 2];

        for (int i = 0; i <= matrix[0].length + 1; i++) {
            visited[0][i] = true;
            visited[matrix.length + 1][i] = true;
        }

        for (int j = 0; j <= matrix.length + 1; j++) {
            visited[j][0] = true;
            visited[j][matrix[0].length + 1] = true;
        }

        ArrayList<Integer> result = new ArrayList<>();

        int x = 1;
        int y = 1;
        result.add(matrix[x - 1][y - 1]);
        visited[x][y] = true;
        while (!visited[x][y + 1] || !visited[x + 1][y] || !visited[x - 1][y] || !visited[x][y - 1]) {
            while (!visited[x][y + 1]) {
                y++;
                result.add(matrix[x - 1][y - 1]);
                visited[x][y] = true;
            }
            while (!visited[x + 1][y]) {
                x++;
                result.add(matrix[x - 1][y - 1]);
                visited[x][y] = true;
            }
            while (!visited[x][y - 1]) {
                y--;
                result.add(matrix[x - 1][y - 1]);
                visited[x][y] = true;
            }
            while (!visited[x - 1][y]) {
                x--;
                result.add(matrix[x - 1][y - 1]);
                visited[x][y] = true;
            }
        }
        return result;
    }
}
