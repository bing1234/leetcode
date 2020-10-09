package com.geekbing.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Interview0809 {
    public List<String> generateParenthesis(int n) {
        Set<String> ans = new HashSet<>();
        if (n == 1) {
            ans.add("()");
            return new ArrayList<>(ans);
        }
        // AB型
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
        List<String> subs = generateParenthesis(n - 1);
        for (String sub : subs) {
            ans.add("(" + sub + ")");
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        Interview0809 interview0809 = new Interview0809();
        System.out.println(interview0809.generateParenthesis(3));
    }
}
