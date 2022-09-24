package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2413 {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }

    @Test
    public void testCase1() {
        LeetCode2413 leetCode2413 = new LeetCode2413();
        assert leetCode2413.smallestEvenMultiple(5) == 10;
    }

    @Test
    public void testCase2() {
        LeetCode2413 leetCode2413 = new LeetCode2413();
        assert leetCode2413.smallestEvenMultiple(6) == 6;
    }
}
