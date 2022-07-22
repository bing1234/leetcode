package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode6033 {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += start & 1 ^ (goal & 1);
            start >>= 1;
            goal >>= 1;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode6033 leetCode6033 = new LeetCode6033();
        assert leetCode6033.minBitFlips(10, 7) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode6033 leetCode6033 = new LeetCode6033();
        assert leetCode6033.minBitFlips(3, 4) == 3;
    }
}
