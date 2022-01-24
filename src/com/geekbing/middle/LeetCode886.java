package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode886 leetCode886 = new LeetCode886();
        assert leetCode886.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}});
    }

    @Test
    public void testCase2() {
        LeetCode886 leetCode886 = new LeetCode886();
        assert !leetCode886.possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}});
    }

    @Test
    public void testCase3() {
        LeetCode886 leetCode886 = new LeetCode886();
        assert !leetCode886.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}});
    }
}
