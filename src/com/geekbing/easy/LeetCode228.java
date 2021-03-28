package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        if (nums.length == 1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        int begin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((long) nums[i] - (long) nums[i - 1] > 1) {
                ans.add(nums[i - 1] == begin ? String.valueOf(begin) : begin + "->" + nums[i - 1]);
                begin = nums[i];
            }
        }
        ans.add(nums[nums.length - 1] == begin ? String.valueOf(begin) : begin + "->" + nums[nums.length - 1]);
        return ans;
    }

    public static void main(String[] args) {
        LeetCode228 leetCode228 = new LeetCode228();
//        System.out.println(leetCode228.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
//        System.out.println(leetCode228.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
//        System.out.println(leetCode228.summaryRanges(new int[]{}));
//        System.out.println(leetCode228.summaryRanges(new int[]{-1}));
//        System.out.println(leetCode228.summaryRanges(new int[]{0}));

        System.out.println(leetCode228.summaryRanges(new int[]{-2147483648, -2147483647, 2147483647}));
    }
}
