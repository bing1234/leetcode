package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode542 {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i + 1 <= row - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 <= col - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }

    @Test
    public void testCase1() {
        LeetCode542 leetCode542 = new LeetCode542();
        int[][] ans = leetCode542.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        });
        int[][] expert = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        assert Arrays.deepEquals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode542 leetCode542 = new LeetCode542();
        int[][] ans = leetCode542.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        });
        int[][] expert = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 2, 1}
        };
        assert Arrays.deepEquals(expert, ans);
    }
}
