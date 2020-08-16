package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        // 定义dp[i][j]为i*j网格路径上的数字总和为最小
        // dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        LeetCode64 leetCode64 = new LeetCode64();
//        int[][] case1 = new int[3][3];
//        case1[0] = new int[]{1, 3, 1};
//        case1[1] = new int[]{1, 5, 1};
//        case1[2] = new int[]{4, 2, 1};
//        System.out.println(leetCode64.minPathSum(case1));
        int[][] case2 = new int[2][3];
        case2[0] = new int[]{1, 2, 5};
        case2[1] = new int[]{3, 2, 1};
        System.out.println(leetCode64.minPathSum(case2));
    }
}
