package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode1162 {
    public int maxDistance(int[][] grid) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1162 leetCode1162 = new LeetCode1162();
        assert leetCode1162.maxDistance(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode1162 leetCode1162 = new LeetCode1162();
        assert leetCode1162.maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}) == 1;
    }
}
