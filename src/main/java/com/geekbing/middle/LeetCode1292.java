package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1292 leetCode1292 = new LeetCode1292();
        assert leetCode1292.maxSideLength(new int[][]{{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}}, 4) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1292 leetCode1292 = new LeetCode1292();
        assert leetCode1292.maxSideLength(new int[][]{{2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}, {2, 2, 2, 2, 2}}, 1) == 0;
    }
}
