package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1784 {
    public boolean checkOnesSegment(String s) {
        char[] chars = s.toCharArray();
        boolean alreadyHas = false;
        boolean preIsOne = chars[0] == '1';
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '1') {
                if (alreadyHas) {
                    return false;
                }
                preIsOne = true;
            } else {
                if (preIsOne) {
                    alreadyHas = true;
                }
                preIsOne = false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1784 leetCode1784 = new LeetCode1784();
        System.out.println(leetCode1784.checkOnesSegment("1001"));
        System.out.println(leetCode1784.checkOnesSegment("110"));
    }
}
