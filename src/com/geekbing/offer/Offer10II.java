package com.geekbing.offer;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Offer10II {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007) % 1000000007;
        }
        return dp[n];
    }

    @Test
    public void testCase1() {
        Offer10II offer10II = new Offer10II();
        assert offer10II.numWays(2) == 2;
    }

    @Test
    public void testCase2() {
        Offer10II offer10II = new Offer10II();
        assert offer10II.numWays(7) == 21;
    }

    @Test
    public void testCase3() {
        Offer10II offer10II = new Offer10II();
        assert offer10II.numWays(0) == 1;
    }
}
