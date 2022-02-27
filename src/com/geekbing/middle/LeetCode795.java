package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode795 leetCode795 = new LeetCode795();
        assert leetCode795.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode795 leetCode795 = new LeetCode795();
        assert leetCode795.numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6}, 2, 8) == 7;
    }
}
