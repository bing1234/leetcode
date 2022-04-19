package com.geekbing.todo;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1165 {
    public int calculateTime(String keyboard, String word) {
        return 0;
    }

    @Test
    public void testCase1() {
        LeetCode1165 leetCode1165 = new LeetCode1165();
        assert leetCode1165.calculateTime("abcdefghijklmnopqrstuvwxyz", "cba") == 4;
    }

    @Test
    public void testCase2() {
        LeetCode1165 leetCode1165 = new LeetCode1165();
        assert leetCode1165.calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode") == 73;
    }
}
