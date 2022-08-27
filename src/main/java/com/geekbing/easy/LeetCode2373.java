package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author bing
 */
public class LeetCode2373 {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                ans[i][j] = maxLocal(grid, i + 1, j + 1);
            }
        }
        return ans;
    }

    private int maxLocal(int[][] grid, int i, int j) {
        int ans = grid[i][j];
        ans = Math.max(ans, grid[i - 1][j - 1]);
        ans = Math.max(ans, grid[i - 1][j]);
        ans = Math.max(ans, grid[i - 1][j + 1]);
        ans = Math.max(ans, grid[i][j - 1]);
        ans = Math.max(ans, grid[i][j + 1]);
        ans = Math.max(ans, grid[i + 1][j - 1]);
        ans = Math.max(ans, grid[i + 1][j]);
        ans = Math.max(ans, grid[i + 1][j + 1]);
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2373 leetCode2373 = new LeetCode2373();
        int[][] ans = leetCode2373.largestLocal(new int[][]{
                {9, 9, 8, 1},
                {5, 6, 2, 6},
                {8, 2, 6, 4},
                {6, 2, 2, 2}
        });
        int[][] expert = new int[][]{
                {9, 9},
                {8, 6}
        };
        assert Objects.deepEquals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2373 leetCode2373 = new LeetCode2373();
        int[][] ans = leetCode2373.largestLocal(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        });
        int[][] expert = new int[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };
        assert Objects.deepEquals(expert, ans);
    }
}
