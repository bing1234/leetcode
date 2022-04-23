package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1118 {
    public int numberOfDays(int year, int month) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1118 leetCode1118 = new LeetCode1118();
        assert leetCode1118.numberOfDays(1992, 7) == 31;
    }

    @Test
    public void testCase2() {
        LeetCode1118 leetCode1118 = new LeetCode1118();
        assert leetCode1118.numberOfDays(2000, 2) == 29;
    }

    @Test
    public void testCase3() {
        LeetCode1118 leetCode1118 = new LeetCode1118();
        assert leetCode1118.numberOfDays(1900, 2) == 28;
    }
}
