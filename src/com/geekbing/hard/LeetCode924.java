package com.geekbing.hard;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode924 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode924 leetCode924 = new LeetCode924();
        int ans = leetCode924.minMalwareSpread(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, new int[]{0, 1});
        assert ans == 0;
    }

    @Test
    public void testCase2() {
        LeetCode924 leetCode924 = new LeetCode924();
        int ans = leetCode924.minMalwareSpread(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, new int[]{0, 2});
        assert ans == 0;
    }

    @Test
    public void testCase3() {
        LeetCode924 leetCode924 = new LeetCode924();
        int ans = leetCode924.minMalwareSpread(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 2});
        assert ans == 1;
    }
}
