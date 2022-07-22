package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1277 {
    public int countSquares(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        // 令dp[i][j]表示以matrix[i][j]为右下角的最大正方形的边长
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 1) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans += dp[i][j];
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1277 leetCode1277 = new LeetCode1277();
        assert leetCode1277.countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        }) == 15;
    }

    @Test
    public void testCase2() {
        LeetCode1277 leetCode1277 = new LeetCode1277();
        assert leetCode1277.countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        }) == 7;
    }
}
