package com.geekbing.easy;

public class LeetCode1332 {
    public int removePalindromeSub(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return 2;
            }
            left++;
            right--;
        }
        return 1;
    }

    public static void main(String[] args) {
        LeetCode1332 leetCode1332 = new LeetCode1332();
        System.out.println(leetCode1332.removePalindromeSub("ababa"));
        System.out.println(leetCode1332.removePalindromeSub("abb"));
        System.out.println(leetCode1332.removePalindromeSub("baabb"));
        System.out.println(leetCode1332.removePalindromeSub(""));
    }
}
