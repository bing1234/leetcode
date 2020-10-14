package com.geekbing.middle;

public class LeetCode1227 {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1.0D;
        }
        if (n == 2) {
            return 0.5D;
        }
        double[] dp = new double[n + 1];
        dp[1] = 1.0D;
        dp[2] = 0.5D;
        for (int i = 3; i <= n; i++) {
            dp[i] = 1.00D / i + 1.00D * (i - 2) / i * dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode1227 leetCode1227 = new LeetCode1227();
        System.out.println(leetCode1227.nthPersonGetsNthSeat(1));
        System.out.println(leetCode1227.nthPersonGetsNthSeat(2));
        System.out.println(leetCode1227.nthPersonGetsNthSeat(3));
        System.out.println(leetCode1227.nthPersonGetsNthSeat(4));
        System.out.println(leetCode1227.nthPersonGetsNthSeat(5));
    }
}
