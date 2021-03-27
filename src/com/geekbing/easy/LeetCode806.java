package com.geekbing.easy;

import java.util.Arrays;

public class LeetCode806 {
    public int[] numberOfLines(int[] widths, String s) {
        if (s.length() == 0) {
            return new int[]{0, 0};
        }
        int lines = 0, curLen = 0;
        for (int c : s.toCharArray()) {
            if (curLen + widths[c - 'a'] > 100) {
                lines++;
                curLen = widths[c - 'a'];
            } else {
                curLen += widths[c - 'a'];
            }
        }
        return new int[]{lines + 1, curLen};
    }

    public static void main(String[] args) {
        LeetCode806 leetCode806 = new LeetCode806();
        System.out.println(Arrays.toString(leetCode806.numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz")));
        System.out.println(Arrays.toString(leetCode806.numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa")));
    }
}
