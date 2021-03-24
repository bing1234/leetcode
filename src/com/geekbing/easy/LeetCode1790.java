package com.geekbing.easy;

public class LeetCode1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (idx1 == -1) {
                    idx1 = i;
                } else if (idx2 == -1) {
                    idx2 = i;
                } else {
                    return false;
                }
            }
        }
        if (idx1 == -1 && idx2 == -1) {
            return true;
        }
        if (idx1 == -1 || idx2 == -1) {
            return false;
        }
        return (s1.charAt(idx1) == s2.charAt(idx1) && s1.charAt(idx2) == s2.charAt(idx2)) ||
                (s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1));
    }

    public static void main(String[] args) {
        LeetCode1790 leetCode1790 = new LeetCode1790();
        System.out.println(leetCode1790.areAlmostEqual("bank", "kanb"));
        System.out.println(leetCode1790.areAlmostEqual("attack", "defend"));
        System.out.println(leetCode1790.areAlmostEqual("kelb", "kelb"));
        System.out.println(leetCode1790.areAlmostEqual("abcd", "dcba"));
    }
}
