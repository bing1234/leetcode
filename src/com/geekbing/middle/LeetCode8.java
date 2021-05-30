package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode8 {
    public int myAtoi(String s) {
        return 0;
    }

    public static void main(String[] args) {
        LeetCode8 leetCode8 = new LeetCode8();

        System.out.println(leetCode8.myAtoi("42"));
        System.out.println(leetCode8.myAtoi("   -42"));
        System.out.println(leetCode8.myAtoi("4193 with words"));
        System.out.println(leetCode8.myAtoi("words and 987"));
        System.out.println(leetCode8.myAtoi("-91283472332"));
    }
}
