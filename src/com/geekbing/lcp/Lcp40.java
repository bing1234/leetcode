package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

/**
 * todo
 *
 * @author bing
 */
public class Lcp40 {
    public int maxmiumScore(int[] cards, int cnt) {
        return 0;
    }

    @Test
    public void testCase1() {
        Lcp40 lcp40 = new Lcp40();
        assert lcp40.maxmiumScore(new int[]{1, 2, 8, 9}, 3) == 18;
    }

    @Test
    public void testCase2() {
        Lcp40 lcp40 = new Lcp40();
        assert lcp40.maxmiumScore(new int[]{3, 3, 1}, 1) == 0;
    }
}
