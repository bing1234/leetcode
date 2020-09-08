package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 0 || k == 0 || n < k) {
            return null;
        }
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                ans.add(temp);
            }
            return ans;
        }
        // 要么在前 n-1个元素中选择k-1个元素, 然后所有结果后面加上n
        List<List<Integer>> subs = combine(n - 1, k - 1);
        if (subs != null) {
            for (List<Integer> sub : subs) {
                sub.add(n);
                ans.add(sub);
            }
        }
        // 要么在前n-1个元素中选择k个
        List<List<Integer>> subs2 = combine(n - 1, k);
        if (subs2 != null) {
            ans.addAll(subs2);
        }
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int n, int k, int level, List<Integer> temp) {
        if (k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (level <= n - k) {
            // 不选择
            temp.add(level);
            backtrack(ans, n, k, level + 1, temp);
        }

        // 选择当前值
        backtrack(ans, n, k, level + 1, temp);

        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        LeetCode77 leetCode77 = new LeetCode77();

        System.out.println(leetCode77.combine(2, 1));
        System.out.println(leetCode77.combine(3, 2));
        System.out.println(leetCode77.combine(4, 2));
    }
}
