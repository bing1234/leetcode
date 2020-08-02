package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        // 以当前元素结尾的乘积最大、最小子数组
        int preMax = nums[0], preMin = nums[0], max = nums[0], currentMax, currentMin;
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], Math.max(nums[i] * preMin, nums[i] * preMax));
            currentMin = Math.min(nums[i], Math.min(nums[i] * preMin, nums[i] * preMax));
            if (currentMax > max) {
                max = currentMax;
            }
            preMax = currentMax;
            preMin = currentMin;
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode152 leetCode152 = new LeetCode152();
        System.out.println(leetCode152.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(leetCode152.maxProduct(new int[]{-2, 0, -1}));
    }
}
