package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        int len = nums.length, maxPosition = 0, end = 0, steps = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    @Test
    public void testCase1() {
        LeetCode45 leetCode45 = new LeetCode45();
        assert leetCode45.jump(new int[]{2, 3, 1, 1, 4}) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode45 leetCode45 = new LeetCode45();
        assert leetCode45.jump(new int[]{2, 3, 0, 1, 4}) == 2;
    }
}
