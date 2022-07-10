package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        // 维护一个[left, right]的滑动区间，保证里面的都是1
        int left = 0, right = 0, ans = 1;
        boolean used = nums[0] == 0;
        while (right + 1 < nums.length) {
            // 如果右边界是1
            if (nums[right + 1] == 1) {
                // 右边界直接扩张
                right++;
                ans = Math.max(ans, right + 1 - left);
            } else {
                // 右边界是0，且还有一次翻转机会
                if (!used) {
                    // 使用掉唯一的一次机会
                    used = true;
                    right++;
                    ans = Math.max(ans, right + 1 - left);
                } else {
                    // 只能左边界收缩
                    if (nums[left] == 0) {
                        left++;
                        // 回收翻转机会
                        used = false;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode487 leetCode487 = new LeetCode487();
        assert leetCode487.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}) == 4;
    }

    @Test
    public void testCase2() {
        LeetCode487 leetCode487 = new LeetCode487();
        assert leetCode487.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}) == 4;
    }

    @Test
    public void testCase3() {
        LeetCode487 leetCode487 = new LeetCode487();
        assert leetCode487.findMaxConsecutiveOnes(new int[]{0, 0}) == 1;
    }
}
