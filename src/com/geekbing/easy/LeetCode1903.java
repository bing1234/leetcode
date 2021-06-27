package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1903 {
    public String largestOddNumber(String num) {
        char c;
        for (int i = num.length() - 1; i >= 0; i--) {
            c = num.charAt(i);
            if ((int) c % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        LeetCode1903 leetCode1903 = new LeetCode1903();

        System.out.println(leetCode1903.largestOddNumber("52"));
        System.out.println(leetCode1903.largestOddNumber("4206"));
        System.out.println(leetCode1903.largestOddNumber("35427"));
    }
}
