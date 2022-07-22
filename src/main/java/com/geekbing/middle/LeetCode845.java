package com.geekbing.middle;

/**
 * 845. 数组中的最长山脉
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 *
 * @author bing
 */
public class LeetCode845 {
    public int longestMountain(int[] A) {
        int ans = 0, left, right;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                // 当前元素A[i]是山峰, 从当前元素开始，向两边延伸
                left = i - 1;
                while (left >= 0 && A[left] < A[left + 1]) {
                    left--;
                }
                right = i + 1;
                while (right < A.length && A[right] < A[right - 1]) {
                    right++;
                }
                ans = Math.max(ans, right - left - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode845 leetCode845 = new LeetCode845();
        System.out.println(leetCode845.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        System.out.println(leetCode845.longestMountain(new int[]{2, 2, 2}));
        System.out.println(leetCode845.longestMountain(new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0}));
    }
}
