package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode346 {
    private static class MovingAverage {

        public MovingAverage(int size) {

        }

        public double next(int val) {
            return 0D;
        }
    }

    @Test
    public void testCase1() {
        MovingAverage movingAverage = new MovingAverage(3);
        assert doubleEqual(movingAverage.next(1), 1.0D);     // 返回 1.0 = 1 / 1
        assert doubleEqual(movingAverage.next(10), 5.5D);    // 返回 5.5 = (1 + 10) / 2
        assert doubleEqual(movingAverage.next(3), 4.66667D); // 返回 4.66667 = (1 + 10 + 3) / 3
        assert doubleEqual(movingAverage.next(5), 6.0D);     // 返回 6.0 = (10 + 3 + 5) / 3
    }

    private boolean doubleEqual(double d1, double d2) {
        return Math.abs(d1 - d2) <= 0.00001D;
    }
}
