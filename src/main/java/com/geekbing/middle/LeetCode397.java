package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode397 {
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }

    @Test
    public void testCase1() {
        LeetCode397 leetCode397 = new LeetCode397();
        assert leetCode397.integerReplacement(8) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode397 leetCode397 = new LeetCode397();
        assert leetCode397.integerReplacement(7) == 4;
    }

    @Test
    public void testCase3() {
        LeetCode397 leetCode397 = new LeetCode397();
        assert leetCode397.integerReplacement(4) == 2;
    }

    @Test
    public void testCase4() {
        LeetCode397 leetCode397 = new LeetCode397();
        assert leetCode397.integerReplacement(1234) == 14;
    }
}
