package com.geekbing.hard;

/**
 * @author bing
 */
public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        // dp[i][j] 表示word1前面长度i的字符串转换为word2前面长度为j的字符串所使用的最少操作数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j] + 1), dp[i][j - 1] + 1);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1), dp[i][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        LeetCode72 leetCode72 = new LeetCode72();
        System.out.println(leetCode72.minDistance("horse", "ros"));
        System.out.println(leetCode72.minDistance("intention", "execution"));
        System.out.println(leetCode72.minDistance("zoologicoarchaeologist", "zoogeologist"));
    }
}
