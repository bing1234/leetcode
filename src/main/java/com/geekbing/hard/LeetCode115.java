package com.geekbing.hard;

/**
 * @author bing
 */
public class LeetCode115 {
    public int numDistinct(String s, String t) {
        // dp[i][j] 表示s(前i个字符串)子序列中T(前j个字符串)出现的个数。
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        LeetCode115 leetCode115 = new LeetCode115();
        System.out.println(leetCode115.numDistinct("rabbbit", "rabbit"));
        System.out.println(leetCode115.numDistinct("babgbag", "bag"));
    }
}
