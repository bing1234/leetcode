package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1688 {
    public int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n % 2 == 0) {
            return n / 2 + numberOfMatches(n / 2);
        } else {
            return (n - 1) / 2 + numberOfMatches((n - 1) / 2 + 1);
        }
    }

    @Test
    public void testCase1() {
        LeetCode1688 leetCode1688 = new LeetCode1688();
        assert leetCode1688.numberOfMatches(7) == 6;
    }

    @Test
    public void testCase2() {
        LeetCode1688 leetCode1688 = new LeetCode1688();
        assert leetCode1688.numberOfMatches(14) == 13;
    }
}
