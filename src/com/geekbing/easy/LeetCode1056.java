package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1056 {
    public boolean confusingNumber(int n) {
        int sum = 0, temp = n, bit;
        while (temp != 0) {
            sum = sum * 10;
            bit = temp % 10;
            if (bit == 2 || bit == 3 || bit == 4 || bit == 5 || bit == 7) {
                return false;
            } else if (bit == 6) {
                sum += 9;
            } else if (bit == 9) {
                sum += 6;
            } else {
                sum += bit;
            }
            temp /= 10;
        }
        return sum != n;
    }

    @Test
    public void testCase1() {
        LeetCode1056 leetCode1056 = new LeetCode1056();
        assert leetCode1056.confusingNumber(6);
    }

    @Test
    public void testCase2() {
        LeetCode1056 leetCode1056 = new LeetCode1056();
        assert leetCode1056.confusingNumber(89);
    }

    @Test
    public void testCase3() {
        LeetCode1056 leetCode1056 = new LeetCode1056();
        assert !leetCode1056.confusingNumber(11);
    }

    @Test
    public void testCase4() {
        LeetCode1056 leetCode1056 = new LeetCode1056();
        assert !leetCode1056.confusingNumber(25);
    }
}
