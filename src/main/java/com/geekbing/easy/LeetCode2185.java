package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2185 {
    public int prefixCount(String[] words, String pref) {
        return (int) Arrays.stream(words).filter(word -> word.startsWith(pref)).count();
    }

    @Test
    public void testCase1() {
        LeetCode2185 leetCode2185 = new LeetCode2185();
        assert leetCode2185.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at") == 2;
    }

    @Test
    public void testCase2() {
        LeetCode2185 leetCode2185 = new LeetCode2185();
        assert leetCode2185.prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code") == 0;
    }
}
