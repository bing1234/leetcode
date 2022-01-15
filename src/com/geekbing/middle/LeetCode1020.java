package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * TODO
 * @author bing
 */
public class LeetCode1020 {
    public int numEnclaves(int[][] grid) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1020 leetCode1020 = new LeetCode1020();
        int[][] grid = new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        assert leetCode1020.numEnclaves(grid) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode1020 leetCode1020 = new LeetCode1020();
        int[][] grid = new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        assert leetCode1020.numEnclaves(grid) == 0;
    }
}
