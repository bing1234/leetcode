package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        // 先看第0行和第0列是否有0存在
        boolean rowHasZero = false, colHasZero = false;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }
        for (int[] row : matrix) {
            if (row[0] == 0) {
                colHasZero = true;
                break;
            }
        }
        // 如果某个格子为0，则将该格子所在行与列的第一个数字设置为0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        if (rowHasZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (colHasZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    @Test
    public void testCase1() {
        LeetCode73 leetCode73 = new LeetCode73();
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        leetCode73.setZeroes(matrix);
        int[][] expert = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        assert Arrays.deepEquals(expert, matrix);
    }

    @Test
    public void testCase2() {
        LeetCode73 leetCode73 = new LeetCode73();
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        leetCode73.setZeroes(matrix);
        int[][] expert = new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        assert Arrays.deepEquals(expert, matrix);
    }
}
