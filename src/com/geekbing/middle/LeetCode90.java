package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode90 {
    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtrack(List<Integer> cur, int[] nums, int start) {
        ans.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            backtrack(cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode90 leetCode90 = new LeetCode90();
        System.out.println(leetCode90.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
