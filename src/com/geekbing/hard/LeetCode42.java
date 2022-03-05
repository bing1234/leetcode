package com.geekbing.hard;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode42 {
    public int trap(int[] height) {
        int len = height.length;
        // left[i] 表示左边最高值；right[i] 表示右边最高值
        int[] left = new int[len], right = new int[len];
        left[0] = 0;
        int leftMax = height[0];
        for (int i = 1; i < len; i++) {
            leftMax = Math.max(leftMax, height[i]);
            left[i] = leftMax;
        }

        right[len - 1] = 0;
        int rightMax = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            right[i] = rightMax;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int cur = Math.min(left[i], right[i]) - height[i];
            if (cur > 0) {
                ans += cur;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode42 leetCode42 = new LeetCode42();
        assert leetCode42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) == 6;
    }

    @Test
    public void testCase2() {
        LeetCode42 leetCode42 = new LeetCode42();
        assert leetCode42.trap(new int[]{4, 2, 0, 3, 2, 5}) == 9;
    }
}
