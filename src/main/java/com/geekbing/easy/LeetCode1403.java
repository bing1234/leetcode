package com.geekbing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(nums[i]);
            sum = sum + nums[i];
            if (total - sum < sum) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1403 leetCode1403 = new LeetCode1403();
        System.out.println(leetCode1403.minSubsequence(new int[]{4, 3, 10, 9, 8}));
        System.out.println(leetCode1403.minSubsequence(new int[]{4, 4, 7, 6, 7}));
        System.out.println(leetCode1403.minSubsequence(new int[]{6}));
    }
}
