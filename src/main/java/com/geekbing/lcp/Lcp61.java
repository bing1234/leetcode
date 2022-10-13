package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Lcp61 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int ans = 0, cur = 0;
        for (int i = 1; i < temperatureA.length; i++) {
            if (Integer.compare(temperatureA[i], temperatureA[i - 1]) == Integer.compare(temperatureB[i], temperatureB[i - 1])) {
                cur++;
                ans = Math.max(ans, cur);
            } else {
                cur = 0;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        Lcp61 lcp61 = new Lcp61();
        int ans = lcp61.temperatureTrend(new int[]{21, 18, 18, 18, 31}, new int[]{34, 32, 16, 16, 17});
        assert ans == 2;
    }

    @Test
    public void testCase2() {
        Lcp61 lcp61 = new Lcp61();
        int ans = lcp61.temperatureTrend(new int[]{5, 10, 16, -6, 15, 11, 3}, new int[]{16, 22, 23, 23, 25, 3, -16});
        assert ans == 3;
    }
}
