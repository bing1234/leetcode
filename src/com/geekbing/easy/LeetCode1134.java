package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1134 {
    public boolean isArmstrong(int n) {
        int sum = 0, temp = n, len = String.valueOf(n).length();
        while (temp != 0) {
            sum += pow(temp % 10, len);
            temp /= 10;
        }
        return sum == n;
    }

    private int pow(int base, int num) {
        if (num == 1) {
            return base;
        }
        int temp = pow(base, num / 2);
        if (num % 2 == 0) {
            return temp * temp;
        }
        return temp * temp * base;
    }

    @Test
    public void testCase1() {
        LeetCode1134 leetCode1134 = new LeetCode1134();
        assert leetCode1134.isArmstrong(153);
    }

    @Test
    public void testCase2() {
        LeetCode1134 leetCode1134 = new LeetCode1134();
        assert !leetCode1134.isArmstrong(123);
    }
}
