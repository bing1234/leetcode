package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class Lcp51 {
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        return 0;
    }

    @Test
    public void testCase1() {
        Lcp51 lcp51 = new Lcp51();
        assert lcp51.perfectMenu(new int[]{3, 2, 4, 1, 2},
                new int[][]{{1, 1, 0, 1, 2}, {2, 1, 4, 0, 0}, {3, 2, 4, 1, 0}},
                new int[][]{{3, 2}, {2, 4}, {7, 6}},
                5) == 7;
    }

    @Test
    public void testCase2() {
        Lcp51 lcp51 = new Lcp51();
        assert lcp51.perfectMenu(new int[]{10, 10, 10, 10, 10},
                new int[][]{{1, 1, 1, 1, 1}, {3, 3, 3, 3, 3}, {10, 10, 10, 10, 10}},
                new int[][]{{5, 5}, {6, 6}, {10, 10}}, 1) == 11;
    }
}
