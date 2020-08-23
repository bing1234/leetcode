package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode264 {
    public int nthUglyNumber(int n) {
        // 丑数就是质因数只包含 2, 3, 5 的正整数
        int[] dp = new int[n + 5];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        for (int i = 6; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                dp[j] * 2

                if (dp[j] * 2 > dp[i - 1] && dp[j] * 2 < min) {
                    min = dp[j] * 2;
                }
                if (dp[j] * 3 > dp[i - 1] && dp[j] * 3 < min) {
                    min = dp[j] * 3;
                }
                if (dp[j] * 5 > dp[i - 1] && dp[j] * 5 < min) {
                    min = dp[j] * 5;
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode264 leetCode264 = new LeetCode264();
        System.out.println(leetCode264.nthUglyNumber(1));
        System.out.println(leetCode264.nthUglyNumber(2));
        System.out.println(leetCode264.nthUglyNumber(3));
        System.out.println(leetCode264.nthUglyNumber(4));
        System.out.println(leetCode264.nthUglyNumber(5));
        System.out.println(leetCode264.nthUglyNumber(10));
        System.out.println(leetCode264.nthUglyNumber(1690));
    }
}
