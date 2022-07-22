package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1405 {
    public String longestDiverseString(int a, int b, int c) {
        return "";
    }

    @Test
    public void testCase1() {
        LeetCode1405 leetCode1405 = new LeetCode1405();
        String ans = leetCode1405.longestDiverseString(1, 1, 7);
        assert "ccaccbcc".equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1405 leetCode1405 = new LeetCode1405();
        String ans = leetCode1405.longestDiverseString(2, 2, 1);
        assert "aabbc".equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode1405 leetCode1405 = new LeetCode1405();
        String ans = leetCode1405.longestDiverseString(7, 1, 0);
        assert "aabaa".equals(ans);
    }
}
