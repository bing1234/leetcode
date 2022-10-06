package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2427 {
    public int commonFactors(int a, int b) {
        int ans = 0;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2427 leetCode2427 = new LeetCode2427();
        int ans = leetCode2427.commonFactors(12, 6);
        assert ans == 4;
    }

    @Test
    public void testCase2() {
        LeetCode2427 leetCode2427 = new LeetCode2427();
        int ans = leetCode2427.commonFactors(25, 30);
        assert ans == 2;
    }
}
