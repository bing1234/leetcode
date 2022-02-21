package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class  LeetCode1438 {
    public int longestSubarray(int[] nums, int limit) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1438 leetCode1438 = new LeetCode1438();
        assert leetCode1438.longestSubarray(new int[]{8, 2, 4, 7}, 4) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1438 leetCode1438 = new LeetCode1438();
        assert leetCode1438.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5) == 4;
    }

    @Test
    public void testCase3() {
        LeetCode1438 leetCode1438 = new LeetCode1438();
        assert leetCode1438.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0) == 3;
    }
}
