package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> cur, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            List<Integer> combine = new ArrayList<>(cur);
            combine.add(candidates[i]);
            backtrack(candidates, target - candidates[i], ans, combine, i);
        }
    }

    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();
        System.out.println(leetCode39.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(leetCode39.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
