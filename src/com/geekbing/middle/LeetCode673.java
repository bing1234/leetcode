package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // lengths[i] 表示以第i个元素为结尾的最长递增子序列的长度
        // counts[i] 表示以第i个元素为结尾的最长递增子序列的个数
        int[] lengths = new int[nums.length];
        int[] counts = new int[nums.length];
        lengths[0] = 1;
        counts[0] = 1;

        // 最长递增子序列的长度
        int longest = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, lengths[j] + 1);
                }
            }
            lengths[i] = max;
            longest = Math.max(longest, lengths[i]);

            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lengths[j] + 1 == lengths[i]) {
                    temp = temp + counts[j];
                }
            }
            counts[i] = temp == 0 ? 1 : temp;
        }

        int result = 0;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] == longest) {
                result = result + counts[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode673 leetCode673 = new LeetCode673();
        System.out.println(leetCode673.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(leetCode673.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(leetCode673.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }
}
