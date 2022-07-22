package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                ans.add(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode442 leetCode442 = new LeetCode442();
        System.out.println(leetCode442.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
