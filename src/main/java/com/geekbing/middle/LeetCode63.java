package com.geekbing.middle;

public class LeetCode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        // dp[i][j] 表示位置(i,j)到终点的方案数
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = obstacleGrid[row - 1][col - 1] == 1 ? 0 : 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (j + 1 < col && obstacleGrid[i][j + 1] == 0) {
                        dp[i][j] = dp[i][j + 1];
                    }
                    if (i + 1 < row && obstacleGrid[i + 1][j] == 0) {
                        dp[i][j] += dp[i + 1][j];
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        LeetCode63 leetCode63 = new LeetCode63();
        System.out.println(leetCode63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(leetCode63.uniquePathsWithObstacles(new int[][]{{0, 1}}));
    }
}
