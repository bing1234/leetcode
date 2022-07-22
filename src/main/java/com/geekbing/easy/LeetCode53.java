package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        // 以当前元素结尾的最大子序列和
        int max = nums[0], pre = nums[0], current;
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], pre + nums[i]);
            if (max < current) {
                max = current;
            }
            pre = current;
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode53 leetCode53 = new LeetCode53();
        System.out.println(leetCode53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
