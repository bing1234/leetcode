package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * TODO
 *
 * @author bing
 */
public class LeetCode2027 {
    public int minimumMoves(String s) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode2027 leetCode2027 = new LeetCode2027();
        assert leetCode2027.minimumMoves("XXX") == 1;
    }

    @Test
    public void testCase2() {
        LeetCode2027 leetCode2027 = new LeetCode2027();
        assert leetCode2027.minimumMoves("XXOX") == 2;
    }

    @Test
    public void testCase3() {
        LeetCode2027 leetCode2027 = new LeetCode2027();
        assert leetCode2027.minimumMoves("OOOO") == 0;
    }
}
