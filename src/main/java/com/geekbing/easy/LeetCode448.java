package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            nums[Math.abs(num) - 1] = -1 * Math.abs(nums[Math.abs(num) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode448 leetCode448 = new LeetCode448();
        System.out.println(leetCode448.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
