package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode125 {
    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        char lowChar, highChar;
        while (low < high) {
            lowChar = s.charAt(low);
            while (!isDigitOrLetter(lowChar) && low < high) {
                low++;
                lowChar = s.charAt(low);
            }

            highChar = s.charAt(high);
            while (!isDigitOrLetter(highChar) && low < high) {
                high--;
                highChar = s.charAt(high);
            }

            if (toLowCase(lowChar) != toLowCase(highChar)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    private char toLowCase(char c) {
        if ('A' <= c && c <= 'Z') {
            return (char) (32 + c);
        }
        return c;
    }

    private boolean isDigitOrLetter(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    public static void main(String[] args) {
        LeetCode125 leetCode125 = new LeetCode125();
        System.out.println(leetCode125.isPalindrome("0P"));
        System.out.println(leetCode125.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(leetCode125.isPalindrome("race a car"));
    }
}
