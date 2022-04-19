package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1165 {
    public int calculateTime(String keyboard, String word) {
        int[] keys = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            keys[keyboard.charAt(i) - 'a'] = i;
        }
        int ans = 0, pre = 0;
        for (int i = 0; i < word.length(); i++) {
            int cur = keys[word.charAt(i) - 'a'];
            ans += Math.abs(cur - pre);
            pre = cur;
        }
        return ans;
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
