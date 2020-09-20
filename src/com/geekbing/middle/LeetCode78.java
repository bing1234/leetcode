package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtrack(List<Integer> cur, int[] nums, int i) {
        ans.add(new ArrayList<>(cur));
        for (int j = i; j < nums.length; j++) {
            cur.add(nums[j]);
            backtrack(cur, nums, j + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode78 leetCode78 = new LeetCode78();
        System.out.println(leetCode78.subsets(new int[]{1, 2, 3}));
    }
}
