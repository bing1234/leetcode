package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
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
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            List<Integer> combo = new ArrayList<>(cur);
            combo.add(candidates[i]);
            backtrack(candidates, target - candidates[i], ans, combo, i + 1);
        }
    }

    public static void main(String[] args) {
        LeetCode40 leetCode40 = new LeetCode40();
        System.out.println(leetCode40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(leetCode40.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
