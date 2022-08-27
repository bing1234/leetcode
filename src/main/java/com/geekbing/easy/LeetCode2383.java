package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2383 leetCode2383 = new LeetCode2383();
        int ans = leetCode2383.minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1});
        assert ans == 8;
    }

    @Test
    public void testCase2() {
        LeetCode2383 leetCode2383 = new LeetCode2383();
        int ans = leetCode2383.minNumberOfHours(2, 4, new int[]{1}, new int[]{3});
        assert ans == 0;
    }
}
