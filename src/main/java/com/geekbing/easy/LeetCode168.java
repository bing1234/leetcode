package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode168 {
    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            int cur = n % 26;
            if (cur == 0) {
                cur = 26;
            }
            ans.insert(0, (char) (cur - 1 + 'A'));
            n = (n - cur) / 26;
        }
        return ans.toString();
    }

    @Test
    public void testCase1() {
        LeetCode168 leetCode168 = new LeetCode168();
        assert leetCode168.convertToTitle(1).equals("A");
    }

    @Test
    public void testCase2() {
        LeetCode168 leetCode168 = new LeetCode168();
        assert leetCode168.convertToTitle(28).equals("AB");
    }

    @Test
    public void testCase3() {
        LeetCode168 leetCode168 = new LeetCode168();
        assert leetCode168.convertToTitle(701).equals("ZY");
    }

    @Test
    public void testCase4() {
        LeetCode168 leetCode168 = new LeetCode168();
        assert leetCode168.convertToTitle(2147483647).equals("FXSHRXW");
    }
}
