package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode457 {
    public boolean circularArrayLoop(int[] nums) {
        int slow = 0, fast = 0;
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode457 leetCode457 = new LeetCode457();
        assert leetCode457.circularArrayLoop(new int[]{2, -1, 1, 2, 2});
    }

    @Test
    public void testCase2() {
        LeetCode457 leetCode457 = new LeetCode457();
        assert !leetCode457.circularArrayLoop(new int[]{-1, 2});
    }

    @Test
    public void testCase3() {
        LeetCode457 leetCode457 = new LeetCode457();
        assert !leetCode457.circularArrayLoop(new int[]{-2, 1, -1, -2, -2});
    }
}
