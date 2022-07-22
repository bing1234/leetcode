package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode718 {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        // dp[i][j]表示以A中下标为i的元素结尾 与 B中下标为j的元素结尾的公共的、长度最长的子数组的长度
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            dp[i][0] = nums1[i] == nums2[0] ? 1 : 0;
            ans = Math.max(ans, dp[i][0]);
        }
        for (int j = 0; j < nums2.length; j++) {
            dp[0][j] = nums1[0] == nums2[j] ? 1 : 0;
            ans = Math.max(ans, dp[0][j]);
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode718 leetCode718 = new LeetCode718();
        assert leetCode718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode718 leetCode718 = new LeetCode718();
        assert leetCode718.findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}) == 5;
    }

    @Test
    public void testCase3() {
        LeetCode718 leetCode718 = new LeetCode718();
        assert leetCode718.findLength(new int[]{1, 2, 3, 2, 8}, new int[]{5, 6, 1, 4, 7}) == 1;
    }
}
