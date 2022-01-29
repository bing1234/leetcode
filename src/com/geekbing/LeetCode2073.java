package com.geekbing;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode2073 leetCode2073 = new LeetCode2073();
        assert leetCode2073.timeRequiredToBuy(new int[]{2, 3, 2}, 2) == 6;
    }

    @Test
    public void testCase2() {
        LeetCode2073 leetCode2073 = new LeetCode2073();
        assert leetCode2073.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0) == 8;
    }
}
