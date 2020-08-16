package com.geekbing.middle;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        // dp[i][j]表示[i,j]范围内的最长回文子序列
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length() - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        LeetCode516 leetCode516 = new LeetCode516();
        System.out.println(leetCode516.longestPalindromeSubseq(""));
        System.out.println(leetCode516.longestPalindromeSubseq("a"));
        System.out.println(leetCode516.longestPalindromeSubseq("bbbab"));
        System.out.println(leetCode516.longestPalindromeSubseq("cbbd"));
    }
}
