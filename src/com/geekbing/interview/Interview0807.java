package com.geekbing.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interview0807 {
    public String[] permutation(String S) {
        List<String> ans = permutation(S, S.length());
        return ans.toArray(new String[0]);
    }

    private List<String> permutation(String S, int count) {
        List<String> ans = new ArrayList<>();
        if (count == 0) {
            return ans;
        }
        if (count == 1) {
            ans.add(String.valueOf(S.charAt(0)));
            return ans;
        }
        List<String> subs = permutation(S, count - 1);
        for (String sub : subs) {
            for (int i = 0; i <= sub.length(); i++) {
                ans.add(insertCharAt(sub, S.charAt(count - 1), i));
            }
        }
        return ans;
    }

    private String insertCharAt(String str, char c, int at) {
        if (at == 0) {
            return c + str;
        }
        if (at == str.length()) {
            return str + c;
        }
        return str.substring(0, at) + c + str.substring(at);
    }

    public static void main(String[] args) {
        Interview0807 interview0807 = new Interview0807();
        System.out.println(Arrays.toString(interview0807.permutation("qwe")));
        System.out.println(Arrays.toString(interview0807.permutation("a")));
        System.out.println(Arrays.toString(interview0807.permutation("ab")));
    }
}
