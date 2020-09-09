package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * todo
 */
public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(Arrays.stream(candidates).boxed().collect(Collectors.toList()), target, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(List<Integer> candidates, int target, List<List<Integer>> ans, List<Integer> cur) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < candidates.size(); i++) {
            if (target < candidates.get(i)) {
                continue;
            }

            List<Integer> combo = new ArrayList<>(cur);
            combo.add(candidates.get(i));
            List<Integer> newCandidates = new ArrayList<>(candidates);
            newCandidates.remove(candidates.get(i));
            backtrack(newCandidates, target - candidates.get(i), ans, combo);
        }
    }


    public static void main(String[] args) {
        LeetCode40 leetCode40 = new LeetCode40();
        System.out.println(leetCode40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(leetCode40.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
