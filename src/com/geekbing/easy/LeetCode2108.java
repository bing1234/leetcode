package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode2108 {
    public String firstPalindrome(String[] words) {
        return Arrays.stream(words).filter(this::isPalindrome).findFirst().orElse("");
    }

    private boolean isPalindrome(String word) {
        char[] chars = word.toCharArray();
        int left = 0, right = word.length() - 1;
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
