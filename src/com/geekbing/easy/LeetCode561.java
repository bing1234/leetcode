package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode561 leetCode561 = new LeetCode561();
        System.out.println(leetCode561.arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
