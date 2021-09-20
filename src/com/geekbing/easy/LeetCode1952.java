package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1952 {
    public boolean isThree(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return false;
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                cnt++;
            }
            if (cnt == 2) {
                return false;
            }
        }
        return cnt == 1;
    }

    @Test
    public void testCase1() {
        LeetCode1952 leetCode1952 = new LeetCode1952();
        assert !leetCode1952.isThree(2);
    }

    @Test
    public void testCase2() {
        LeetCode1952 leetCode1952 = new LeetCode1952();
        assert leetCode1952.isThree(4);
    }
}
