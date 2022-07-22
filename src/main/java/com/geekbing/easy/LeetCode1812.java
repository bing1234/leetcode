package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1812 {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) - 'a' + 1 + coordinates.charAt(1) - '0') % 2 != 0;
    }

    public static void main(String[] args) {
        LeetCode1812 leetCode1812 = new LeetCode1812();
        System.out.println(leetCode1812.squareIsWhite("a1"));
        System.out.println(leetCode1812.squareIsWhite("h3"));
        System.out.println(leetCode1812.squareIsWhite("c7"));
    }
}
