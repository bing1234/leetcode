package com.geekbing.easy;

import org.junit.jupiter.api.Test;

/**
 * @author bing
 */
public class LeetCode680 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return isPalindrome(chars, left + 1, right) || isPalindrome(chars, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void testCase1() {
        LeetCode680 leetCode680 = new LeetCode680();
        assert leetCode680.validPalindrome("aba");
    }

    @Test
    public void testCase2() {
        LeetCode680 leetCode680 = new LeetCode680();
        assert leetCode680.validPalindrome("abca");
    }

    @Test
    public void testCase3() {
        LeetCode680 leetCode680 = new LeetCode680();
        assert !leetCode680.validPalindrome("abc");
    }

    @Test
    public void testCase4() {
        LeetCode680 leetCode680 = new LeetCode680();
        assert !leetCode680.validPalindrome("bddb");
    }
}
