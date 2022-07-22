package com.geekbing.interview;

/**
 * @author bing
 */
public class Interview0801 {
    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        // dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        Interview0801 interview0801 = new Interview0801();
        System.out.println(interview0801.waysToStep(3));
        System.out.println(interview0801.waysToStep(5));
        System.out.println(interview0801.waysToStep(1000000));
    }
}
