package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2319 {
    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i == j || i + j == grid.length - 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode2319 leetCode2319 = new LeetCode2319();
        assert leetCode2319.checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}});
    }

    @Test
    public void testCase2() {
        LeetCode2319 leetCode2319 = new LeetCode2319();
        assert !leetCode2319.checkXMatrix(new int[][]{{5, 7, 0}, {0, 3, 1}, {0, 5, 0}});
    }
}
