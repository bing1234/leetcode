package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode96 {
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // dp[i]表示1...i组成互不相同的二叉树的数量
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // dp[2] = dp[0] * dp[1] + dp[1] * dp[0] = 2;
        // dp[3] = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0] = 5;
        // dp[4] = dp[0] * dp[3] + dp[1] * dp[2] + dp[2] * dp[1] + dp[3] * dp[0] =
        for (int i = 2; i <= n; i++) {
            for (int left = 0; left < i; left++) {
                dp[i] += dp[left] * dp[i - left - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode96 leetCode96 = new LeetCode96();

        System.out.println(leetCode96.numTrees(1));
        System.out.println(leetCode96.numTrees(2));
        System.out.println(leetCode96.numTrees(3));
    }
}
