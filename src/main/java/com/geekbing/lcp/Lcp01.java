package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Lcp01 {
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void testCase1() {
        Lcp01 lcp01 = new Lcp01();
        assert lcp01.game(new int[]{1, 2, 3}, new int[]{1, 2, 3}) == 3;
    }

    @Test
    public void testCase2() {
        Lcp01 lcp01 = new Lcp01();
        assert lcp01.game(new int[]{2, 2, 3}, new int[]{3, 2, 1}) == 1;
    }
}
