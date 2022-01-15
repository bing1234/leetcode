package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * @author bing
 */
public class LeetCode1967 {
    public int numOfStrings(String[] patterns, String word) {
        return (int) Stream.of(patterns).parallel().filter(word::contains).count();
    }

    @Test
    public void testCase1() {
        LeetCode1967 leetCode1967 = new LeetCode1967();
        int ans = leetCode1967.numOfStrings(new String[]{"a", "abc", "bc", "d"}, "abc");
        assert ans == 3;
    }

    @Test
    public void testCase2() {
        LeetCode1967 leetCode1967 = new LeetCode1967();
        int ans = leetCode1967.numOfStrings(new String[]{"a", "b", "c"}, "aaaaabbbbb");
        assert ans == 2;
    }

    @Test
    public void testCase3() {
        LeetCode1967 leetCode1967 = new LeetCode1967();
        int ans = leetCode1967.numOfStrings(new String[]{"a", "a", "a"}, "ab");
        assert ans == 3;
    }
}
