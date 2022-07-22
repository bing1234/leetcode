package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1979 {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return gcd(max, min);
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    @Test
    public void testCase1() {
        LeetCode1979 leetCode1979 = new LeetCode1979();
        int ans = leetCode1979.findGCD(new int[]{2, 5, 6, 9, 10});
        assert ans == 2;
    }

    @Test
    public void testCase2() {
        LeetCode1979 leetCode1979 = new LeetCode1979();
        int ans = leetCode1979.findGCD(new int[]{7, 5, 6, 8, 3});
        assert ans == 1;
    }

    @Test
    public void testCase3() {
        LeetCode1979 leetCode1979 = new LeetCode1979();
        int ans = leetCode1979.findGCD(new int[]{3, 3});
        assert ans == 3;
    }
}
