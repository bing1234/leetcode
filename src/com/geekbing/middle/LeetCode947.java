package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author bing
 */
public class LeetCode947 {
    public int removeStones(int[][] stones) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode947 leetCode947 = new LeetCode947();
        int[][] stones = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        assert leetCode947.removeStones(stones) == 5;
    }

    @Test
    public void testCase2() {
        LeetCode947 leetCode947 = new LeetCode947();
        int[][] stones = new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        assert leetCode947.removeStones(stones) == 3;
    }

    @Test
    public void testCase3() {
        LeetCode947 leetCode947 = new LeetCode947();
        int[][] stones = new int[][]{{0, 0}};
        assert leetCode947.removeStones(stones) == 0;
    }
}
