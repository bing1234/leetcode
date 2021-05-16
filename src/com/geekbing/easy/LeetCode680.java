package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode680 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();

        return true;
    }

    public static void main(String[] args) {
        LeetCode680 leetCode680 = new LeetCode680();
        System.out.println(leetCode680.validPalindrome("a"));
        System.out.println(leetCode680.validPalindrome("ab"));
        System.out.println(leetCode680.validPalindrome("abc"));
        System.out.println(leetCode680.validPalindrome("aba"));
        System.out.println(leetCode680.validPalindrome("abca"));
    }
}
