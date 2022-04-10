package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode518 {
    public int change(int amount, int[] coins) {
        return 1;
    }

    @Test
    public void testCase1() {
        LeetCode518 leetCode518 = new LeetCode518();
        assert leetCode518.change(5, new int[]{1, 2, 5}) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode518 leetCode518 = new LeetCode518();
        assert leetCode518.change(3, new int[]{2}) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode518 leetCode518 = new LeetCode518();
        assert leetCode518.change(10, new int[]{10}) == 1;
    }
}
