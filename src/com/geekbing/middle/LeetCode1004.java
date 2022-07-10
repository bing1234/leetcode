package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1004 {
    public int longestOnes(int[] nums, int k) {
        // 维护一个滑动窗口[left, right]，保证窗口内的值都是1
        int left = 0, right = 0, ans = k;
        if (k == 0) {
            return findContinueSame(nums);
        }
        if (nums[0] == 0) {
            k--;
        }
        while (right + 1 < nums.length) {
            // 右边界是1，则直接扩张
            if (nums[right + 1] == 1) {
                right++;
                ans = Math.max(ans, right + 1 - left);
            } else {
                // 右边界不是1，还有反转次数
                if (k > 0) {
                    k--;
                    right++;
                    ans = Math.max(ans, right + 1 - left);
                } else {
                    // 没有反转次数了，那只能左边界收缩
                    if (nums[left] == 1) {
                        left++;
                    } else {
                        left++;
                        // 回收翻转次数
                        k++;
                    }
                }
            }
        }
        return ans;
    }

    private int findContinueSame(int[] nums) {
        int ans = 0, curCnt = 0;
        for (int num : nums) {
            if (num == 1) {
                curCnt++;
                ans = Math.max(ans, curCnt);
            } else {
                curCnt = 0;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode1004 leetCode1004 = new LeetCode1004();
        assert leetCode1004.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2) == 6;
    }

    @Test
    public void testCase2() {
        LeetCode1004 leetCode1004 = new LeetCode1004();
        assert leetCode1004.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3) == 10;
    }
}
