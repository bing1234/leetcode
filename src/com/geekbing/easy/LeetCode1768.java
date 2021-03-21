package com.geekbing.easy;

public class LeetCode1768 {
    public String mergeAlternately(String word1, String word2) {
        // 特殊情况处理
        if (word1 == null || word1.length() == 0) {
            return word2;
        }
        if (word2 == null || word2.length() == 0) {
            return word1;
        }
        StringBuilder ans = new StringBuilder();
        int idx1 = 0, idx2 = 0;
        while (idx1 < word1.length() && idx2 < word2.length()) {
            ans.append(word1.charAt(idx1));
            ans.append(word2.charAt(idx2));
            idx1++;
            idx2++;
        }
        if (idx1 < word1.length()) {
            while (idx1 < word1.length()) {
                ans.append(word1.charAt(idx1));
                idx1++;
            }
        }
        if (idx2 < word2.length()) {
            while (idx2 < word2.length()) {
                ans.append(word2.charAt(idx2));
                idx2++;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode1768 leetCode1768 = new LeetCode1768();
        System.out.println(leetCode1768.mergeAlternately("abc", "pqr"));
        System.out.println(leetCode1768.mergeAlternately("ab", "pqrs"));
        System.out.println(leetCode1768.mergeAlternately("abcd", "pq"));
    }
}
