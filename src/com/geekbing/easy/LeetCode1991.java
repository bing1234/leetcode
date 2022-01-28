package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode1991 {
    public int findMiddleIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == total - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    @Test
    public void testCase1() {
        LeetCode1991 leetCode1991 = new LeetCode1991();
        assert leetCode1991.findMiddleIndex(new int[]{2, 3, -1, 8, 4}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode1991 leetCode1991 = new LeetCode1991();
        assert leetCode1991.findMiddleIndex(new int[]{1, -1, 4}) == 2;
    }

    @Test
    public void testCase3() {
        LeetCode1991 leetCode1991 = new LeetCode1991();
        assert leetCode1991.findMiddleIndex(new int[]{2, 5}) == -1;
    }
}
