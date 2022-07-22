package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2235 {
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    @Test
    public void testCase1() {
        LeetCode2235 leetCode2235 = new LeetCode2235();
        assert leetCode2235.sum(12, 5) == 17;
    }

    @Test
    public void testCase2() {
        LeetCode2235 leetCode2235 = new LeetCode2235();
        assert leetCode2235.sum(-10, 4) == -6;
    }
}
