package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode6 {
    public String convert(String s, int numRows) {
        return "";
    }

    @Test
    public void testCase1() {
        LeetCode6 leetCode6 = new LeetCode6();
        assert leetCode6.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR");
    }

    @Test
    public void testCase2() {
        LeetCode6 leetCode6 = new LeetCode6();
        assert leetCode6.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI");
    }

    @Test
    public void testCase3() {
        LeetCode6 leetCode6 = new LeetCode6();
        assert leetCode6.convert("A", 1).equals("A");
    }
}
