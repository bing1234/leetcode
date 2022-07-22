package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2303 {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0D;
        int left = income, range;
        for (int i = 0; i < brackets.length; i++) {
            range = i == 0 ? brackets[0][0] : brackets[i][0] - brackets[i - 1][0];
            if (left < range) {
                ans += left * brackets[i][1] / 100D;
                return ans;
            }
            ans += range * brackets[i][1] / 100D;
            left -= range;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2303 leetCode2303 = new LeetCode2303();
        double ans = leetCode2303.calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10);
        assert doubleEqual(ans, 2.65000D);
    }

    @Test
    public void testCase2() {
        LeetCode2303 leetCode2303 = new LeetCode2303();
        double ans = leetCode2303.calculateTax(new int[][]{{1, 0}, {4, 25}, {5, 50}}, 2);
        assert doubleEqual(ans, 0.25000);
    }

    @Test
    public void testCase3() {
        LeetCode2303 leetCode2303 = new LeetCode2303();
        double ans = leetCode2303.calculateTax(new int[][]{{2, 50}}, 0);
        assert doubleEqual(ans, 0D);
    }

    @Test
    public void testCase4() {
        LeetCode2303 leetCode2303 = new LeetCode2303();
        double ans = leetCode2303.calculateTax(new int[][]{{2, 7}, {3, 17}, {4, 37}, {7, 6}, {9, 83}, {16, 67}, {19, 29}}, 18);
        assert doubleEqual(ans, 7.79D);
    }

    private boolean doubleEqual(double d1, double d2) {
        return Math.abs(d1 - d2) < 0.00001D;
    }
}
