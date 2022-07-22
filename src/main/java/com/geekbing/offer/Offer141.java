package com.geekbing.offer;

/**
 * @author bing
 */
public class Offer141 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = dp[i - 1];
            for (int j = 1; j < i; j++) {
                max = maxOfArr(max, (i - j) * j, dp[i - j] * j, (i - j) * dp[j], dp[i - j] * dp[j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    private int maxOfArr(int... arrs) {
        int max = arrs[0];
        for (int arr : arrs) {
            if (max < arr) {
                max = arr;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Offer141 offer141 = new Offer141();
        System.out.println(offer141.cuttingRope(2));
        System.out.println(offer141.cuttingRope(10));
    }
}
