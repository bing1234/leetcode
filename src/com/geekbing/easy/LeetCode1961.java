package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode1961 {
    public boolean isPrefixString(String s, String[] words) {
        int idx = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != s.charAt(idx)) {
                    return false;
                }
                idx++;
                if (idx == s.length()) {
                    return i == word.length() - 1;
                }
            }
        }
        return false;
    }

    @Test
    public void testCase1() {
        LeetCode1961 leetCode1961 = new LeetCode1961();
        boolean ans = leetCode1961.isPrefixString("iloveleetcode", new String[]{"i", "love", "leetcode", "apples"});
        assert ans;
    }

    @Test
    public void testCase2() {
        LeetCode1961 leetCode1961 = new LeetCode1961();
        boolean ans = leetCode1961.isPrefixString("iloveleetcode", new String[]{"apples", "i", "love", "leetcode"});
        assert !ans;
    }

    @Test
    public void testCase3() {
        LeetCode1961 leetCode1961 = new LeetCode1961();
        boolean ans = leetCode1961.isPrefixString("a", new String[]{"aa", "aaaa", "banana"});
        assert !ans;
    }
}
