package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode221 {
    public int maximalSquare(char[][] matrix) {
        int side = 0, row = matrix.length, col = matrix[0].length;
        // 令dp[i][j]表示以[i][j]为右下角的最大正方形的边长
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            side = Math.max(side, dp[i][0]);
        }
        for (int j = 0; j < col; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            side = Math.max(side, dp[0][j]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
                side = Math.max(side, dp[i][j]);
            }
        }
        return side * side;
    }

    @Test
    public void testCase1() {
        LeetCode221 leetCode221 = new LeetCode221();
        int ans = leetCode221.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        });
        assert ans == 4;
    }

    @Test
    public void testCase2() {
        LeetCode221 leetCode221 = new LeetCode221();
        int ans = leetCode221.maximalSquare(new char[][]{
                {'0', '1'},
                {'1', '0'}
        });
        assert ans == 1;
    }
}
