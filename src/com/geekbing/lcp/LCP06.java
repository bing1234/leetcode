package com.geekbing.lcp;

/**
 * @author bing
 */
public class LCP06 {
    public int minCount(int[] coins) {
        int times = 0;
        for (int coin : coins) {
            if (coin % 2 == 0) {
                times = times + coin / 2;
            } else {
                times = times + coin / 2 + 1;
            }
        }
        return times;
    }

    public static void main(String[] args) {
        LCP06 lcp06 = new LCP06();
        System.out.println(lcp06.minCount(new int[]{4, 2, 1}));
        System.out.println(lcp06.minCount(new int[]{2, 3, 10}));
    }
}
