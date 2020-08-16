package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode279 {
    public int numSquares(int n) {
        // dp[i]表示组成正整数i所需的完全平方数最少的个数
        // dp[i] = min(dp[i - j * j]) + 1;  1<=j*j<=i
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (dp[i - j * j] < min) {
                    min = dp[i - j * j] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode279 leetCode279 = new LeetCode279();
        System.out.println(leetCode279.numSquares(12));
        System.out.println(leetCode279.numSquares(13));
    }
}
