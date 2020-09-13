package com.geekbing.middle;

import java.util.Arrays;

public class LeetCode462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, left = 0, right = nums.length - 1;
        while (left < right) {
            ans += nums[right] - nums[left];
            left++;
            right--;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode462 leetCode462 = new LeetCode462();
        System.out.println(leetCode462.minMoves2(new int[]{1, 2, 3}));
    }
}
