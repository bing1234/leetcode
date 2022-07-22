package com.geekbing.middle;

import java.util.ArrayList;
import java.util.List;

public class LeetCode784 {
    private List<String> ans;

    public List<String> letterCasePermutation(String S) {
        ans = new ArrayList<>();
        backtrack(S.toCharArray(), 0);
        return ans;
    }

    private void backtrack(char[] chars, int idx) {
        if (idx == chars.length) {
            ans.add(new String(chars));
            return;
        }
        backtrack(chars, idx + 1);
        if ('A' <= chars[idx] && chars[idx] <= 'Z') {
            chars[idx] = (char) (chars[idx] + 32);
            backtrack(chars, idx + 1);
        } else if ('a' <= chars[idx] && chars[idx] <= 'z') {
            chars[idx] = (char) (chars[idx] - 32);
            backtrack(chars, idx + 1);
        }
    }

    public static void main(String[] args) {
        LeetCode784 leetCode784 = new LeetCode784();
        System.out.println(leetCode784.letterCasePermutation("a1b2"));
        System.out.println(leetCode784.letterCasePermutation("3z4"));
        System.out.println(leetCode784.letterCasePermutation("12345"));
    }
}
