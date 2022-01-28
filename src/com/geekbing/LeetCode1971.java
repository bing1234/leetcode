package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1971 {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode1971 leetCode1971 = new LeetCode1971();
        assert leetCode1971.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2);
    }

    @Test
    public void testCase2() {
        LeetCode1971 leetCode1971 = new LeetCode1971();
        assert !leetCode1971.validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5);
    }
}
