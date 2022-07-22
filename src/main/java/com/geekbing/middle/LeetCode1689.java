package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode1689 {
    public int minPartitions(String n) {
        int max = 0;
        char[] chars = n.toCharArray();
        for (char c : chars) {
            max = Math.max(max, c - '0');
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode1689 leetCode1689 = new LeetCode1689();
        System.out.println(leetCode1689.minPartitions("32"));
        System.out.println(leetCode1689.minPartitions("82734"));
        System.out.println(leetCode1689.minPartitions("27346209830709182346"));
    }
}
