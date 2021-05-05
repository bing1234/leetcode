package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode551 {
    public boolean checkRecord(String s) {
        boolean hasA = false;
        boolean preTwoIsL = false;
        boolean preOneIsL = false;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                if (hasA) {
                    return false;
                }
                hasA = true;
                preOneIsL = false;
            } else if (c == 'L') {
                if (preOneIsL && preTwoIsL) {
                    return false;
                }
                if (preOneIsL) {
                    preTwoIsL = true;
                }
                preOneIsL = true;
            } else {
                preOneIsL = false;
                preTwoIsL = false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode551 leetCode551 = new LeetCode551();
        System.out.println(leetCode551.checkRecord("PPALLP"));
        System.out.println(leetCode551.checkRecord("PPALLL"));
    }
}
