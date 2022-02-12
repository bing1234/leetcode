package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode7 {
    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + (x % 10);
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) sum;
    }

    @Test
    public void testCase1() {
        LeetCode7 leetCode7 = new LeetCode7();
        assert leetCode7.reverse(123) == 321;
    }

    @Test
    public void testCase2() {
        LeetCode7 leetCode7 = new LeetCode7();
        assert leetCode7.reverse(-123) == -321;
    }

    @Test
    public void testCase3() {
        LeetCode7 leetCode7 = new LeetCode7();
        assert leetCode7.reverse(120) == 21;
    }

    @Test
    public void testCase4() {
        LeetCode7 leetCode7 = new LeetCode7();
        assert leetCode7.reverse(0) == 0;
    }
}
