package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode6051 {
    public int countPrefixes(String[] words, String s) {
        return (int) Arrays.stream(words).filter(s::startsWith).count();
    }

    @Test
    public void testCase1() {
        LeetCode6051 leetCode6051 = new LeetCode6051();
        assert leetCode6051.countPrefixes(new String[]{"a", "b", "c", "ab", "bc", "abc"}, "abc") == 3;
    }

    @Test
    public void testCase2() {
        LeetCode6051 leetCode6051 = new LeetCode6051();
        assert leetCode6051.countPrefixes(new String[]{"a", "a"}, "aa") == 2;
    }
}
