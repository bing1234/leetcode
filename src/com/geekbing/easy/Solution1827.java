package com.geekbing.easy;

/**
 * @author bing
 */
public class Solution1827 {
    public int minOperations(int[] nums) {
        int ans = 0, pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                pre = nums[i];
            } else if (nums[i] == pre) {
                ans++;
                pre = pre + 1;
            } else {
                ans += pre + 1 - nums[i];
                pre = pre + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1827 solution1827 = new Solution1827();
        System.out.println(solution1827.minOperations(new int[]{1, 1, 1}));
        System.out.println(solution1827.minOperations(new int[]{1, 5, 2, 4, 1}));
        System.out.println(solution1827.minOperations(new int[]{8}));
    }
}
