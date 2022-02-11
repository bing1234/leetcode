package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode650 {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        if (n % 2 != 0) {
            return n;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 3; i < n; i++) {
            if (n % i == 0) {
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode650 leetCode650 = new LeetCode650();
        int ans = leetCode650.minSteps(3);
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode650 leetCode650 = new LeetCode650();
        assert leetCode650.minSteps(1) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode650 leetCode650 = new LeetCode650();
        assert leetCode650.minSteps(9) == 6;
    }
}
