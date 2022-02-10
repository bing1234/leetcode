package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode91 {
    public int numDecodings(String s) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode91 leetCode91 = new LeetCode91();
        assert leetCode91.numDecodings("12") == 2;
    }

    @Test
    public void testCase2() {
        LeetCode91 leetCode91 = new LeetCode91();
        assert leetCode91.numDecodings("226") == 3;
    }

    @Test
    public void testCase3() {
        LeetCode91 leetCode91 = new LeetCode91();
        assert leetCode91.numDecodings("0") == 0;
    }
}
