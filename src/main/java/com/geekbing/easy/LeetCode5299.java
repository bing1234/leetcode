package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode5299 {
    public int divisorSubstrings(int num, int k) {
        int ans = 0, cur;
        String numStr = String.valueOf(num);
        for (int i = 0; i + k <= numStr.length(); i++) {
            cur = Integer.parseInt(numStr.substring(i, i + k));
            if (cur != 0 && num % cur == 0) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode5299 leetCode5299 = new LeetCode5299();
        assert leetCode5299.divisorSubstrings(240, 2) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode5299 leetCode5299 = new LeetCode5299();
        assert leetCode5299.divisorSubstrings(430043, 2) == 2;
    }

    @Test
    public void testCase3() {
        LeetCode5299 leetCode5299 = new LeetCode5299();
        assert leetCode5299.divisorSubstrings(10, 1) == 1;
    }

    @Test
    public void testCase4() {
        LeetCode5299 leetCode5299 = new LeetCode5299();
        assert leetCode5299.divisorSubstrings(30003, 3) == 1;
    }
}
