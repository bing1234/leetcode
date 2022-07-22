package com.geekbing.hard;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        // 先解决负数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 2;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            // 需要标记的下标为num-1
            if (num - 1 < nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    @Test
    public void testCase1() {
        LeetCode41 leetCode41 = new LeetCode41();
        assert leetCode41.firstMissingPositive(new int[]{1, 2, 0}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode41 leetCode41 = new LeetCode41();
        assert leetCode41.firstMissingPositive(new int[]{3, 4, -1, 1}) == 2;
    }

    @Test
    public void testCase3() {
        LeetCode41 leetCode41 = new LeetCode41();
        assert leetCode41.firstMissingPositive(new int[]{7, 8, 9, 11, 12}) == 1;
    }

    @Test
    public void testCase4() {
        LeetCode41 leetCode41 = new LeetCode41();
        assert leetCode41.firstMissingPositive(new int[]{1, 1}) == 2;
    }
}
