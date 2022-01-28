package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode2108 {
    public String firstPalindrome(String[] words) {
        return null;
    }

    @Test
    public void testCase1() {
        LeetCode2108 leetCode2108 = new LeetCode2108();
        assert leetCode2108.firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"}).equals("ada");
    }

    @Test
    public void testCase2() {
        LeetCode2108 leetCode2108 = new LeetCode2108();
        assert leetCode2108.firstPalindrome(new String[]{"notapalindrome", "racecar"}).equals("racecar");
    }

    @Test
    public void testCase3() {
        LeetCode2108 leetCode2108 = new LeetCode2108();
        assert leetCode2108.firstPalindrome(new String[]{"def", "ghi"}).equals("");
    }
}
