package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int ans = 10, cur = 9;
        for (int i = 2; i <= n; i++) {
            cur = cur * (9 - i + 2);
            ans += cur;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode357 leetCode357 = new LeetCode357();
        assert leetCode357.countNumbersWithUniqueDigits(2) == 91;
    }

    @Test
    public void testCase2() {
        LeetCode357 leetCode357 = new LeetCode357();
        assert leetCode357.countNumbersWithUniqueDigits(0) == 1;
    }
}
