package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode5755 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, ans = 0;
        while (left < right) {
            ans = Math.max(ans, nums[left] + nums[right]);
            left++;
            right--;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode5755 leetCode5755 = new LeetCode5755();
        System.out.println(leetCode5755.minPairSum(new int[]{3, 5, 2, 3}));
        System.out.println(leetCode5755.minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
        System.out.println(leetCode5755.minPairSum(new int[]{3, 2, 4, 1, 1, 5, 1, 3, 5, 1}));
    }
}
