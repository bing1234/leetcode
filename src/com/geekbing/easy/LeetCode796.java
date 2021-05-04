package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode796 {
    public boolean rotateString(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        for (int i = 0; i < A.length(); i++) {
            if (A.equals(B)) {
                return true;
            }
            A = A.substring(1) + A.charAt(0);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode796 solution796 = new LeetCode796();
        System.out.println(solution796.rotateString("abcde", "cdeab"));
        System.out.println(solution796.rotateString("abcde", "abced"));
    }
}
