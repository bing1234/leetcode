package com.geekbing.middle;

public class LeetCode1155 {
    private static final int MOD = 1000000007;

    public int numRollsToTarget(int d, int f, int target) {
        // dp[i][j] 表示扔i个骰子和为j的组合数
        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] +... dp[i-1][j-f];
        int[][] dp = new int[d + 1][target + 1];
        for (int i = 1; i <= Math.min(f, target); i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= target; j++) {
                int total = 0;
                for (int k = 1; j > k && k <= f; k++) {
                    total = total + dp[i - 1][j - k];
                    total = total % MOD;
                }
                dp[i][j] = total % MOD;
            }
        }
        return dp[d][target];
    }

    public static void main(String[] args) {
        LeetCode1155 leetCode1155 = new LeetCode1155();
        System.out.println(leetCode1155.numRollsToTarget(1, 6, 3));
        System.out.println(leetCode1155.numRollsToTarget(2, 6, 7));
        System.out.println(leetCode1155.numRollsToTarget(2, 5, 10));
        System.out.println(leetCode1155.numRollsToTarget(1, 2, 3));
        System.out.println(leetCode1155.numRollsToTarget(30, 30, 50));
    }
}
