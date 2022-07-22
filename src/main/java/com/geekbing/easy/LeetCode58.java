package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return len;
            }
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        LeetCode58 leetCode58 = new LeetCode58();
        System.out.println(leetCode58.lengthOfLastWord("a "));
        System.out.println(leetCode58.lengthOfLastWord("Hello World"));
    }
}
