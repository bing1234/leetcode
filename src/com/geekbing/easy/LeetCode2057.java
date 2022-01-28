package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2057 {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void testCase1() {
        LeetCode2057 leetCode2057 = new LeetCode2057();
        assert leetCode2057.smallestEqual(new int[]{0, 1, 2}) == 0;
    }

    @Test
    public void testCase2() {
        LeetCode2057 leetCode2057 = new LeetCode2057();
        assert leetCode2057.smallestEqual(new int[]{4, 3, 2, 1}) == 2;
    }

    @Test
    public void testCase3() {
        LeetCode2057 leetCode2057 = new LeetCode2057();
        assert leetCode2057.smallestEqual(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) == -1;
    }

    @Test
    public void testCase4() {
        LeetCode2057 leetCode2057 = new LeetCode2057();
        assert leetCode2057.smallestEqual(new int[]{2, 1, 3, 5, 2}) == 1;
    }
}
