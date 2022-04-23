package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class Lcp50 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] opera : operations) {
            int num = gem[opera[0]] / 2;
            gem[opera[0]] -= num;
            gem[opera[1]] += num;
        }
        int max = gem[0], min = gem[0];
        for (int i = 1; i < gem.length; i++) {
            max = Math.max(max, gem[i]);
            min = Math.min(min, gem[i]);
        }
        return max - min;
    }

    @Test
    public void testCase1() {
        Lcp50 lcp50 = new Lcp50();
        assert lcp50.giveGem(new int[]{3, 1, 2}, new int[][]{{0, 2}, {2, 1}, {2, 0}}) == 2;
    }

    @Test
    public void testCase2() {
        Lcp50 lcp50 = new Lcp50();
        assert lcp50.giveGem(new int[]{100, 0, 50, 100}, new int[][]{{0, 2}, {0, 1}, {3, 0}, {3, 0}}) == 75;
    }

    @Test
    public void testCase3() {
        Lcp50 lcp50 = new Lcp50();
        assert lcp50.giveGem(new int[]{0, 0, 0, 0}, new int[][]{{1, 2}, {3, 1}, {1, 2}}) == 0;
    }
}
