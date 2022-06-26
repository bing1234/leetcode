package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2293 {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int[] newArr = new int[nums.length / 2];
        for (int i = 0; i < newArr.length; i++) {
            if (i % 2 == 0) {
                newArr[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
            } else {
                newArr[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
            }
        }
        return minMaxGame(newArr);
    }

    @Test
    public void testCase1() {
        LeetCode2293 leetCode2293 = new LeetCode2293();
        assert leetCode2293.minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}) == 1;
    }

    @Test
    public void testCase2() {
        LeetCode2293 leetCode2293 = new LeetCode2293();
        assert leetCode2293.minMaxGame(new int[]{3}) == 3;
    }
}
