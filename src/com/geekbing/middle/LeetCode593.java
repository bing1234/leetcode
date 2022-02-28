package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (samePoint(p1, p2) || samePoint(p1, p3) || samePoint(p1, p4) || samePoint(p2, p3) || samePoint(p2, p4) || samePoint(p3, p4)) {
            return false;
        }
        int[] lens = new int[]{squaresLen(p1, p2), squaresLen(p1, p3), squaresLen(p1, p4), squaresLen(p2, p3), squaresLen(p2, p4), squaresLen(p3, p4)};
        Arrays.sort(lens);
        return lens[0] == lens[1] && lens[0] == lens[2] && lens[0] == lens[3] && lens[4] == lens[5] && 2 * lens[0] == lens[5];
    }

    private boolean samePoint(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    private int squaresLen(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    @Test
    public void testCase1() {
        LeetCode593 leetCode593 = new LeetCode593();
        assert leetCode593.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1});
    }

    @Test
    public void testCase2() {
        LeetCode593 leetCode593 = new LeetCode593();
        assert !leetCode593.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 12});
    }

    @Test
    public void testCase3() {
        LeetCode593 leetCode593 = new LeetCode593();
        assert leetCode593.validSquare(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1});
    }
}
