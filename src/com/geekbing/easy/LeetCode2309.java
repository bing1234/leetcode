package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2309 {
    public String greatestLetter(String s) {
        int[] bucket = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                bucket[c - 'a'] |= 1;
            }
            if (Character.isUpperCase(c)) {
                bucket[c - 'A'] |= 2;
            }
        }
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == 3) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }

    @Test
    public void testCase1() {
        LeetCode2309 leetCode2309 = new LeetCode2309();
        assert leetCode2309.greatestLetter("lEeTcOdE").equals("E");
    }

    @Test
    public void testCase2() {
        LeetCode2309 leetCode2309 = new LeetCode2309();
        assert leetCode2309.greatestLetter("arRAzFif").equals("R");
    }

    @Test
    public void testCase3() {
        LeetCode2309 leetCode2309 = new LeetCode2309();
        assert leetCode2309.greatestLetter("AbCdEfGhIjK").equals("");
    }
}
