package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2210 {
    public int countHillValley(int[] nums) {
        int cnt = 0;
        if (nums == null || nums.length < 3) {
            return cnt;
        }

        // 找到第一个不等于nums[0]的下标
        int i = 1;
        while (i < nums.length) {
            // 找到第一个和前面不相等的数
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i >= nums.length) {
                return cnt;
            }
            if (nums[i - 1] < nums[i]) {
                // 处于上升期
                while (i < nums.length && nums[i - 1] <= nums[i]) {
                    i++;
                }
                if (i < nums.length) {
                    // 找到了一个峰顶
                    cnt++;
                }
            } else {
                // 处于下降期
                while (i < nums.length && nums[i - 1] >= nums[i]) {
                    i++;
                }
                if (i < nums.length) {
                    // 找到一个峰谷
                    cnt++;
                }
            }
        }
        return cnt;
    }

    @Test
    public void testCase1() {
        LeetCode2210 leetCode2210 = new LeetCode2210();
        assert leetCode2210.countHillValley(new int[]{2, 4, 1, 1, 6, 5}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode2210 leetCode2210 = new LeetCode2210();
        assert leetCode2210.countHillValley(new int[]{6, 6, 5, 5, 4, 1}) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode2210 leetCode2210 = new LeetCode2210();
        assert leetCode2210.countHillValley(new int[]{1, 1, 1}) == 0;
    }
}
