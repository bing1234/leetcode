package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1101 {
    public int earliestAcq(int[][] logs, int n) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1101 leetCode1101 = new LeetCode1101();
        assert leetCode1101.earliestAcq(new int[][]{{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}}, 6) == 20190301;
    }

    @Test
    public void testCase2() {
        LeetCode1101 leetCode1101 = new LeetCode1101();
        assert leetCode1101.earliestAcq(new int[][]{{0, 2, 0}, {1, 0, 1}, {3, 0, 3}, {4, 1, 2}, {7, 3, 1}}, 4) == 3;
    }
}
