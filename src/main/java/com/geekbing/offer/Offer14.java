package com.geekbing.offer;

import java.math.BigInteger;

/**
 * @author bing
 */
public class Offer14 {
    public int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = new BigInteger("1");
        BigInteger max, temp;
        for (int i = 2; i <= n; i++) {
            max = dp[i - 1];
            for (int j = 1; j < i; j++) {
                temp = dp[i - j].multiply(dp[j]);
                temp = temp.max(dp[i - j].multiply(new BigInteger(String.valueOf(j))));
                temp = temp.max(new BigInteger(String.valueOf(i - j)).multiply(dp[j]));
                temp = temp.max(new BigInteger(String.valueOf((i - j) * j)));
                max = temp.max(max);
            }
            dp[i] = max;
        }
        return dp[n].mod(new BigInteger("1000000007")).intValue();
    }

    public static void main(String[] args) {
        Offer14 offer14 = new Offer14();
        System.out.println(offer14.cuttingRope(2));
        System.out.println(offer14.cuttingRope(10));
        System.out.println(offer14.cuttingRope(120));
    }
}
