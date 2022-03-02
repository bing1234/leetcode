package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode50 {
    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0D / quickMul(x, -(long) n);
    }

    private double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0D;
        }
        if (n == 1) {
            return x;
        }
        double y = quickMul(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        }
        return y * y * x;
    }

    @Test
    public void testCase1() {
        LeetCode50 leetCode50 = new LeetCode50();
        double ans = leetCode50.myPow(2.00000, 10);
        double expert = 1024.00000D;
        assert Math.abs(expert - ans) < 0.00001D;
    }

    @Test
    public void testCase2() {
        LeetCode50 leetCode50 = new LeetCode50();
        double ans = leetCode50.myPow(2.10000, 3);
        double expert = 9.26100D;
        assert Math.abs(expert - ans) < 0.00001D;
    }

    @Test
    public void testCase3() {
        LeetCode50 leetCode50 = new LeetCode50();
        double ans = leetCode50.myPow(2.00000, -2);
        double expert = 0.25000D;
        assert Math.abs(expert - ans) < 0.00001D;
    }

    @Test
    public void testCase4() {
        LeetCode50 leetCode50 = new LeetCode50();
        double ans = leetCode50.myPow(0.00001, -2147483647);
        double expert = 0.25000D;
        assert Math.abs(expert - ans) < 0.00001D;
    }

    @Test
    public void testCase5() {
        LeetCode50 leetCode50 = new LeetCode50();
        double ans = leetCode50.myPow(0.00001, 2147483647);
        double expert = 0.0000D;
        assert Math.abs(expert - ans) < 0.00001D;
    }
}
