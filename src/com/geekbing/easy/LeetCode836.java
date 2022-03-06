package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long overWidth = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        long overHeight = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        long over = Math.max(overWidth, 0) * Math.max(overHeight, 0);
        return over > 0L;
    }

    @Test
    public void testCase1() {
        LeetCode836 leetCode836 = new LeetCode836();
        assert leetCode836.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3});
    }

    @Test
    public void testCase2() {
        LeetCode836 leetCode836 = new LeetCode836();
        assert !leetCode836.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1});
    }

    @Test
    public void testCase3() {
        LeetCode836 leetCode836 = new LeetCode836();
        assert !leetCode836.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{2, 2, 3, 3});
    }
}
