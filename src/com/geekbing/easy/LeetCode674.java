package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        // 以当前元素结尾的最长连续递增序列
        int maxLen = 1, preLen = 1, currentLen;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLen = preLen + 1;
            } else {
                currentLen = 1;
            }
            if (maxLen < currentLen) {
                maxLen = currentLen;
            }
            preLen = currentLen;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LeetCode674 leetCode674 = new LeetCode674();
        System.out.println(leetCode674.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(leetCode674.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }
}
