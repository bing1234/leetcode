package com.geekbing.middle;

public class LeetCode807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMaxes = new int[grid.length];
        int[] colMaxes = new int[grid[0].length];
        // 每行的最大值
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (max < grid[i][j]) {
                    max = grid[i][j];
                }
            }
            rowMaxes[i] = max;
        }
        // 每列的最大值
        for (int j = 0; j < grid[0].length; j++) {
            int max = 0;
            for (int[] ints : grid) {
                if (max < ints[j]) {
                    max = ints[j];
                }
            }
            colMaxes[j] = max;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans += Math.min(rowMaxes[i], colMaxes[j]) - grid[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode807 leetCode807 = new LeetCode807();
        System.out.println(leetCode807.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }
}
