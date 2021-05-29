package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1544 {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        char cur, next;
        int i = 0;
        while (i < sb.length() - 1) {
            cur = sb.charAt(i);
            next = sb.charAt(i + 1);
            if (cur + 32 == next || next + 32 == cur) {
                sb.deleteCharAt(i + 1);
                sb.deleteCharAt(i);
                i = Math.max(0, i - 1);
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1544 leetCode1544 = new LeetCode1544();
        System.out.println(leetCode1544.makeGood("leEeetcode"));
        System.out.println(leetCode1544.makeGood("abBAcC"));
        System.out.println(leetCode1544.makeGood("s"));
    }
}
