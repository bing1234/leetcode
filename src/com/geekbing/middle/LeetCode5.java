package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        // dp[i][j] 表示 s[i...j]是否是s的回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int left = 0, right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || j - i < 3)) {
                    dp[i][j] = true;
                    if (right - left < j - i) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        LeetCode5 leetCode5 = new LeetCode5();
        System.out.println(leetCode5.longestPalindrome("babad"));
        System.out.println(leetCode5.longestPalindrome("cbbd"));
    }
}
