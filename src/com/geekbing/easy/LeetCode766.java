package com.geekbing.easy;

public class LeetCode766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        int curRow, curCol, curNum;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                curRow = i;
                curCol = j;
                curNum = matrix[curRow][curCol];
                while (curRow < row && curCol < col) {
                    if (curNum != matrix[curRow][curCol]) {
                        return false;
                    }
                    curRow++;
                    curCol++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode766 leetCode766 = new LeetCode766();

        System.out.println(leetCode766.isToeplitzMatrix(new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        }));
        System.out.println(leetCode766.isToeplitzMatrix(new int[][]{
                {1, 2},
                {2, 2},
        }));
    }
}
