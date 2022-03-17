package com.geekbing.hard;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1579 leetCode1579 = new LeetCode1579();
        assert leetCode1579.maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}}) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1579 leetCode1579 = new LeetCode1579();
        assert leetCode1579.maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}}) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode1579 leetCode1579 = new LeetCode1579();
        assert leetCode1579.maxNumEdgesToRemove(4, new int[][]{{3, 2, 3}, {1, 1, 2}, {2, 3, 4}}) == -1;
    }
}
