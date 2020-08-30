package com.geekbing.middle;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String[][] dp = new String[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = String.valueOf(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = s.charAt(i) + (dp[i + 1][j - 1] == null ? "" : dp[i + 1][j - 1]) + s.charAt(i);
                } else {
                    if (dp[i + 1][j].length() > dp[i][j - 1].length()) {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        LeetCode5 leetCode5 = new LeetCode5();
        System.out.println(leetCode5.longestPalindrome("babad"));
        System.out.println(leetCode5.longestPalindrome("cbbd"));
    }
}
