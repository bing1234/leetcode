package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode1641 {
    public int countVowelStrings(int n) {
        // dp[i][c] 表示长度为i且以c字符结尾的数量
        int[][] dp = new int[n + 1][5];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
            dp[i][4] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
        }

        return dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4];
    }

    public static void main(String[] args) {
        LeetCode1641 leetCode1641 = new LeetCode1641();

        System.out.println(leetCode1641.countVowelStrings(1));
        System.out.println(leetCode1641.countVowelStrings(2));
        System.out.println(leetCode1641.countVowelStrings(33));
    }
}
