package com.geekbing.middle;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode318 {
    public int maxProduct(String[] words) {
        return 0;
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
