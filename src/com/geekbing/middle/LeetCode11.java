package com.geekbing.middle;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 11. 盛最多水的容器
 *
 * @author bing
 */
public class LeetCode11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = (right - left) * Math.min(height[left], height[right]);
        while (left < right) {
            if (height[left] < height[right]) {
                // 移动左边的
                int leftHeight = height[left];
                while (left < right && height[left] <= leftHeight) {
                    left++;
                }
                ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            } else {
                // 移动右边的
                int rightHeight = height[right];
                while (left < right && height[right] <= rightHeight) {
                    right--;
                }
                ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode11 leetCode11 = new LeetCode11();
        System.out.println(leetCode11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
