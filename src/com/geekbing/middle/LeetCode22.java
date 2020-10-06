package com.geekbing.middle;

import java.util.*;

public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            List<String> ans = new ArrayList<>();
            ans.add("()");
            return ans;
        }
        Set<String> ans = new HashSet<>();
        // AB型号
        for (int i = 1; i < n; i++) {
            List<String> lefts = generateParenthesis(i);
            List<String> rights = generateParenthesis(n - i);
            for (String left : lefts) {
                for (String right : rights) {
                    ans.add(left + right);
                }
            }
        }
        // (A)型
        List<String> items = generateParenthesis(n - 1);
        for (String item : items) {
            ans.add("(" + item + ")");
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        System.out.println(leetCode22.generateParenthesis(3));
    }
}
