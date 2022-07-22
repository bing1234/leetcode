package com.geekbing.easy;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode344 {
    public void reverseString(char[] s) {
        if (s.length < 2) {
            return;
        }

        int low = 0;
        int high = s.length - 1;

        char temp;
        while (low < high) {
            if (s[low] != s[high]) {
                temp = s[low];
                s[low] = s[high];
                s[high] = temp;
            }
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        LeetCode344 leetCode344 = new LeetCode344();

        char[] s1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        leetCode344.reverseString(s1);
        System.out.println(Arrays.toString(s1));

        char[] s2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        leetCode344.reverseString(s2);
        System.out.println(Arrays.toString(s2));
    }
}
