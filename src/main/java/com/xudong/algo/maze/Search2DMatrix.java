package com.xudong.algo.maze;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearchCol(matrix, target, 0, matrix.length);
    }

    boolean binarySearchCol(int[][] matrix, int target, int start, int end) {
        int mid = (end + start) / 2;
        if (target > matrix[mid][0]) {
            if ((mid + 1 < matrix.length && target < matrix[mid + 1][0]) || mid == matrix.length - 1)
                return binarySearchRow(matrix[mid], target, 0, matrix[0].length);
            if (target == matrix[mid + 1][0]) return true;
            return binarySearchCol(matrix, target, mid, end);
        } else if (target < matrix[mid][0]) {
            if ((mid - 1 >= 0 && target >= matrix[mid - 1][0]) || mid == 1)
                return binarySearchRow(matrix[mid - 1], target, 0, matrix[0].length);
            if (mid == 0) return false;

            return binarySearchCol(matrix, target, start, mid);
        } else return true;
    }

    private boolean binarySearchRow(int[] row, int target, int start, int end) {
        if (start == end - 1) return row[start] == target;
        int mid = (start + end) / 2;
        if (row[mid] < target) return binarySearchRow(row, target, mid, end);
        else if (row[mid] > target) return binarySearchRow(row, target, start, mid);
        else return true;
    }
}
