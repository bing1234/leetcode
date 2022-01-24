package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author bing
 */
public class LeetCode1631 {
    public int minimumEffortPath(int[][] heights) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1631 leetCode1631 = new LeetCode1631();
        int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        assert leetCode1631.minimumEffortPath(heights) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1631 leetCode1631 = new LeetCode1631();
        int[][] heights = new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        assert leetCode1631.minimumEffortPath(heights) == 1;
    }

    @Test
    public void testCase3() {
        LeetCode1631 leetCode1631 = new LeetCode1631();
        int[][] heights = new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        assert leetCode1631.minimumEffortPath(heights) == 0;
    }
}
