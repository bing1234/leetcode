package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2104 {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }

    @Test
    public void testCase1() {
        LeetCode2104 leetCode2104 = new LeetCode2104();
        assert leetCode2104.subArrayRanges(new int[]{1, 2, 3}) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode2104 leetCode2104 = new LeetCode2104();
        assert leetCode2104.subArrayRanges(new int[]{1, 3, 3}) == 4;
    }

    @Test
    public void testCase3() {
        LeetCode2104 leetCode2104 = new LeetCode2104();
        assert leetCode2104.subArrayRanges(new int[]{4, -2, -3, 4, 1}) == 59;
    }
}
