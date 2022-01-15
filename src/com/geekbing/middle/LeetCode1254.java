package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * TODO
 * @author bing
 */
public class LeetCode1254 {
    public int closedIsland(int[][] grid) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1254 leetCode1254 = new LeetCode1254();
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        assert leetCode1254.closedIsland(grid) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1254 leetCode1254 = new LeetCode1254();
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };
        assert leetCode1254.closedIsland(grid) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode1254 leetCode1254 = new LeetCode1254();
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };
        assert leetCode1254.closedIsland(grid) == 2;
    }
}
