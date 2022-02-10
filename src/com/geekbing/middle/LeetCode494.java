package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int target) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode494 leetCode494 = new LeetCode494();
        assert leetCode494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3) == 5;
    }

    @Test
    public void testCase2() {
        LeetCode494 leetCode494 = new LeetCode494();
        assert leetCode494.findTargetSumWays(new int[]{1}, 1) == 1;
    }
}
