package com.geekbing.lcp;

import org.junit.jupiter.api.Test;

/**
 * todo
 *
 * @author bing
 */
public class Lcp39 {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        return 0;
    }

    @Test
    public void testCase1() {
        Lcp39 lcp39 = new Lcp39();
        int[][] source = new int[][]{{1, 3}, {5, 4}};
        int[][] target = new int[][]{{3, 1}, {6, 5}};
        assert lcp39.minimumSwitchingTimes(source, target) == 1;
    }

    @Test
    public void testCase2() {
        Lcp39 lcp39 = new Lcp39();
        int[][] source = new int[][]{{1, 2, 3}, {3, 4, 5}};
        int[][] target = new int[][]{{1, 3, 5}, {2, 3, 4}};
        assert lcp39.minimumSwitchingTimes(source, target) == 0;
    }
}
