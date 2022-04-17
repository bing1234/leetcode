package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode318 {
    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        // 将一个单词映射为一个整数
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bits[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode318 leetCode318 = new LeetCode318();
        assert leetCode318.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}) == 16;
    }

    @Test
    public void testCase2() {
        LeetCode318 leetCode318 = new LeetCode318();
        assert leetCode318.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}) == 4;
    }

    @Test
    public void testCase3() {
        LeetCode318 leetCode318 = new LeetCode318();
        assert leetCode318.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}) == 0;
    }
}
