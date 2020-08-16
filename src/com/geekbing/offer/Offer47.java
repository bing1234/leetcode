package com.geekbing.offer;

/**
 * @author bing
 */
public class Offer47 {
    public int maxValue(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Offer47 offer47 = new Offer47();
        int[][] case1 = new int[3][3];
        case1[0] = new int[]{1, 3, 1};
        case1[1] = new int[]{1, 5, 1};
        case1[2] = new int[]{4, 2, 1};
        System.out.println(offer47.maxValue(case1));
    }
}
