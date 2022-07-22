package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtract(ans, new ArrayList<>(), k, n, 1);
        return ans;
    }

    private void backtract(List<List<Integer>> ans, List<Integer> cur, int k, int n, int start) {
        for (int i = start; i <= 9; i++) {
            if (i > n) {
                return;
            }
            if (i == n) {
                if (k != 1) {
                    break;
                }
                List<Integer> combo = new ArrayList<>(cur);
                combo.add(i);
                ans.add(combo);
            } else {
                List<Integer> combo = new ArrayList<>(cur);
                combo.add(i);
                backtract(ans, combo, k - 1, n - i, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode216 leetCode216 = new LeetCode216();
        System.out.println(leetCode216.combinationSum3(3, 7));
        System.out.println(leetCode216.combinationSum3(3, 9));
    }
}
