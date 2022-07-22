package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || "".equals(text1) || text2 == null || "".equals(text2)) {
            return 0;
        }
        // dp[i][j]表示text1前i个字符与text2前j个字符的最长公共子序列
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        LeetCode1143 leetCode1143 = new LeetCode1143();
        System.out.println(leetCode1143.longestCommonSubsequence("abcde", "ace"));
        System.out.println(leetCode1143.longestCommonSubsequence("abc", "abc"));
        System.out.println(leetCode1143.longestCommonSubsequence("abc", "def"));
    }
}
