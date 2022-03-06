package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int total = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2) + Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        int overWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        int over = Math.max(overWidth, 0) * Math.max(overHeight, 0);
        return total - over;
    }

    @Test
    public void testCase1() {
        LeetCode223 leetCode223 = new LeetCode223();
        assert leetCode223.computeArea(-3, 0, 3, 4, 0, -1, 9, 2) == 45;
    }

    @Test
    public void testCase2() {
        LeetCode223 leetCode223 = new LeetCode223();
        assert leetCode223.computeArea(-2, -2, 2, 2, -2, -2, 2, 2) == 16;
    }
}
